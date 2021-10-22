package com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToColorful

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
import com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToColorful.adapterColorFul.AdapterColorFul
import com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToColorful.adapterColorFul.DataColorfulFavorite
import com.example.fontforinstagram.repository.SingletonRepository
import com.example.fontforinstagram.repository.room.favoriteFontsColorfull.FontsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class View_SwitchToColorful : Fragment() {

    private var colorFullDao : FontsDao? = null
    private var recyclerSwitchToColorful : RecyclerView? = null
    private var listAdapter : ArrayList<DataColorfulFavorite> = arrayListOf()
    private var mHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_switch_to_colorful, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerSwitchToColorful = view.findViewById(R.id.recyclerSwitchToColorful)
        colorFullDao = SingletonRepository.dataBaseFonts(requireContext()).fontsDao()

        runBlocking {
            var listColorFull = colorFullDao?.getllAllFonts()
            for (i in listColorFull!!){
                listAdapter.add(DataColorfulFavorite(i.id, i.imageFont, i.iconLike, true))
            }

        }



        var adapter = object : AdapterColorFul(listAdapter){
            override fun deleteFont(position: Int) {

                lifecycleScope.launch(Dispatchers.Main) {
                    colorFullDao?.deleteById(position)


                    mHandler.post(Runnable {
                        listAdapter.removeAt(position);
                        notifyItemRemoved(position);
                    })
                }



            }

        }



        recyclerSwitchToColorful!!.layoutManager = LinearLayoutManager(context)
        recyclerSwitchToColorful!!.adapter = adapter
    }
}