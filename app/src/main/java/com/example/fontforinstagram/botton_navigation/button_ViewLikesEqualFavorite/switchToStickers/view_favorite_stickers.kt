package com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToStickers

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.repository.SingletonRepository
import com.example.fontforinstagram.repository.room.favoriteFontsColorfull.FontsDao
import com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToStickers.adapter.DataFavorite


class view_favorite_stickers : Fragment() {

    private var recyclerView : RecyclerView? = null
    private var listFavorite  = arrayListOf<DataFavorite>()
    lateinit var fontsDao: FontsDao
    private var mHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_favorite_stickers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerFavoriteStickers)
        fontsDao = SingletonRepository.dataBaseFonts(requireContext()).fontsDao()

//        runBlocking {
//
//                val favorite = fontsDao.getllAllFonts()
//
//                        for (i in favorite){
//                            listFavorite.add(DataFavorite(i.id, i.imageFont, i.iconLike))
//                        }
//        }
//
//        var adapter = object : AdapterFavoriteStickers(listFavorite){
//            override fun getPosition(position: Int) {
//
//            }
//
//            override fun deletePosition(position: Int) {
//                lifecycleScope.launch(Dispatchers.Main){
//                    withContext(Dispatchers.IO){
////                        fontsDao.deleteById(position)
//                        fontsDao.deleteById(position)
//                        mHandler.post(Runnable {
//                            listFavorite.removeAt(position)
//                            notifyDataSetChanged()
//
//                        })
//                    }
//                    Log.d("111", fontsDao.getllAllFonts().toString() + "qweq")
//
//                }
//
//            }
//
//        }

//        recyclerView!!.layoutManager = LinearLayoutManager(context)
//        recyclerView!!.adapter = adapter



    }
}