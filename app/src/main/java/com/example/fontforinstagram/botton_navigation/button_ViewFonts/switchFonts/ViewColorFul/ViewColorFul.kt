package com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.ViewColorFul

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
import com.example.fontforinstagram.repository.room.favoriteFontsColorfull.FavoriteFonts
import com.example.fontforinstagram.repository.room.favoriteFontsColorfull.FontsDao
import com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.ViewColorFul.adapterColorFull.AdapterColorFull
import com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.ViewColorFul.adapterColorFull.DataColorFull
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

        fontsDao = SingletonRepository.dataBaseFonts(requireContext()).fontsDao()

        mutListFonts.add(DataColorFull(0, R.drawable.ic_yesteryear, R.drawable.ic_like_disabled))
        if (mutListFonts.count() <= 0) {
            for (font in mutListFonts) {
                lifecycleScope.launch(Dispatchers.IO) {
                    if (fontsDao.isExists(font.id).isNotEmpty()) {
                        font.isFavorite = true
                    }
                }
            }
        }




        var adapterFontss = object : AdapterColorFull(mutListFonts) {


            override fun addToFavorite(font: Int, position: Int, iconLike: Int) {
                lifecycleScope.launch(Dispatchers.IO) {


                    fontsDao.insertFont(
                        FavoriteFonts(
                            position,
                            mutListFonts[position].fonts,
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
        }



        recyclerView!!.adapter = adapterFontss
        recyclerView!!.layoutManager = LinearLayoutManager(context)
    }
}