package com.example.fontforinstagram.viewFonts.switchFonts.ViewColorFul

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.repository.SingletonRepository
import com.example.fontforinstagram.repository.room.FavoriteFonts
import com.example.fontforinstagram.repository.room.FontsDao
import com.example.fontforinstagram.viewFonts.switchFonts.ViewColorFul.adapterColorFull.AdapterColorFull
import com.example.fontforinstagram.viewFonts.switchFonts.ViewColorFul.adapterColorFull.DataColorFull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewColorFul : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var mutListFonts: ArrayList<DataColorFull> = arrayListOf()
    private lateinit var fontsDao: FontsDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_color_ful, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewFonts)

        mutListFonts.add(DataColorFull(R.drawable.ic_yesteryear, R.drawable.ic_like_for_favorite))

        fontsDao = SingletonRepository.dataBaseFonts(requireContext()).fontsDao()


        var adapterFontss = object : AdapterColorFull(mutListFonts) {


            override fun addToFavorite(font: Int, position: Int, iconLike: Int) {
                lifecycleScope.launch(Dispatchers.IO) {

                    fontsDao.insertFont(
                        FavoriteFonts(
                            position,
                            mutListFonts[position].fonts!!,
                            iconLike
                        )
                    )

                }

            }

            override fun deleteFavorite(position: Int) {
                lifecycleScope.launch(Dispatchers.IO) {
                    fontsDao.deleteById(position)

                }
            }

            override fun saveIconLike(position: Int, counter: Int) {
                TODO("Not yet implemented")
            }

        }

        recyclerView!!.adapter = adapterFontss
        recyclerView!!.layoutManager = LinearLayoutManager(context)
    }
}