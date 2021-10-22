package com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.viewClassic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.repository.SingletonRepository
import com.example.fontforinstagram.repository.room.favoriteFontsClassic.FavoriteClassic
import com.example.fontforinstagram.repository.room.favoriteFontsClassic.FontsClassicDao
import com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.viewClassic.adapterClassic.AdapterClassic
import com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.viewClassic.adapterClassic.DataClassic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewClassic : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var mutListClassic: ArrayList<DataClassic> = arrayListOf()
    lateinit var fontClassic: FontsClassicDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_classic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerClassic)
        fontClassic = SingletonRepository.dataBaseFonts(requireContext()).fontsClassic()
        mutListClassic.add(
            DataClassic(
                0,
                R.drawable.ic_yesterday_without_shadow,
                R.drawable.ic_like_disabled
            )
        )
        for (mutlist in mutListClassic) {
            lifecycleScope.launch(Dispatchers.IO) {
                if (fontClassic.isLiked(mutlist.id).isNotEmpty()){
                    mutlist.isFavorite = true
                }
            }
        }


        var adapterClassic = object : AdapterClassic(mutListClassic) {
            override fun addToFavorite(position: Int, image: Int, icon_like: Int) {
                lifecycleScope.launch(Dispatchers.IO) {
                    fontClassic.insertFontClassic(
                        FavoriteClassic(
                            position, mutListClassic[position].fonts, icon_like
                        )
                    )
                }
            }

            override fun deletePosition(position: Int) {
                lifecycleScope.launch(Dispatchers.IO){
                    fontClassic.deleteById(position)

                }
            }


        }
        recyclerView!!.adapter = adapterClassic
        recyclerView!!.layoutManager = LinearLayoutManager(context)
    }
}