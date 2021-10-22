package com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToClassic

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToClassic.adapterClassic.AdapterClassicFavorite
import com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToClassic.adapterClassic.DataClassicFavorite
import com.example.fontforinstagram.repository.SingletonRepository
import com.example.fontforinstagram.repository.room.favoriteFontsClassic.FontsClassicDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class View_SwitchToClassic : Fragment() {

    private var recyclerClassicFavorite : RecyclerView? = null
    private var favoriteClassicDao : FontsClassicDao? = null
    private var listFavoriteClassic : ArrayList<DataClassicFavorite> = arrayListOf()
    private var mHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view__switch_to_classic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerClassicFavorite = view.findViewById(R.id.recyclerViewFavoriteClassic)
        favoriteClassicDao = SingletonRepository.dataBaseFonts(requireContext()).fontsClassic()

        runBlocking {
            var getFavoriteClassic = favoriteClassicDao!!.getAllFontsClassic()
            for (i in getFavoriteClassic){
                listFavoriteClassic.add(DataClassicFavorite(i.id, i.imageFont, i.isLike))
            }

        }


        var adapter = object : AdapterClassicFavorite(listFavoriteClassic){

            override fun delete(position: Int) {
                lifecycleScope.launch(Dispatchers.Main){
                    favoriteClassicDao!!.deleteById(position)

                    mHandler.post(Runnable {
                        listFavoriteClassic.removeAt(position)
                        notifyItemRemoved(position)
                    })

                }

            }

        }
        recyclerClassicFavorite!!.layoutManager = LinearLayoutManager(context)
        recyclerClassicFavorite!!.adapter = adapter
    }
}