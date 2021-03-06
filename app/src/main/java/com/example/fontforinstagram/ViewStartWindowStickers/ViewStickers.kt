package com.example.fontforinstagram.ViewStartWindowStickers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.Singleton
import com.example.fontforinstagram.viewFonts.ViewFonts
import com.example.fontforinstagram.ViewStartWindowStickers.adapter.AdapterStickers
import com.example.fontforinstagram.ViewStartWindowStickers.adapter.DataStickersModelView
import com.example.fontforinstagram.viewLikes.ViewFavoritesLikes
import com.google.android.material.bottomnavigation.BottomNavigationView


class ViewStickers : Fragment(), IViewStickers.View {

   private var listSticker = arrayListOf<DataStickersModelView>()
   private  var recycler : RecyclerView? = null

    private var presenter = PresenterStickers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_stickers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        var botnav : BottomNavigationView = view.findViewById(R.id.botNavigation)
        recycler = view.findViewById(R.id.recyclerViewSticker)

        listSticker.add(DataStickersModelView("Telegram smiles", R.drawable.smile1,
        R.drawable.smile2, R.drawable.smile3
            ))


        var stickerAdapter = object : AdapterStickers(listSticker){
            override fun position(position: Int) {
                Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            }


        }

        recycler?.layoutManager = LinearLayoutManager(context)
        recycler?.adapter = stickerAdapter



        // var botnav : BottomNavigationView = view.findViewById(R.id.botNavigation)
        botnav.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.stickerss -> {
                    Singleton.switchFragment(ViewStickers())

                    Toast.makeText(context, "qeqwq", Toast.LENGTH_SHORT).show()
                }
                R.id.fontss -> {
//                    Singleton.switchFragment(ViewMovingText())
                    changeFragment(ViewFonts())

                    // Respond to navigation item 2 reselection
                    Toast.makeText(context, "qeqwq", Toast.LENGTH_SHORT).show()

                }

                R.id.likess -> {
                    changeFragment(ViewFavoritesLikes())
                }
            }
        }



    }


    private fun changeFragment(ft : Fragment){
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.frameNavMenu, ft)
            commit()
        }
    }


    override fun switchViewFragment(ft: Fragment) {
    }

    override fun goToSelectedSticker(position: Int) {

    }
}