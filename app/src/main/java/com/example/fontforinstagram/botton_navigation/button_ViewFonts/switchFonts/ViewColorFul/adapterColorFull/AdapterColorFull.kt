package com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.ViewColorFul.adapterColorFull

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.Singleton
import com.example.fontforinstagram.viewAddingText.ViewAddingText

abstract  class AdapterColorFull(var dataListFonts: ArrayList<DataColorFull>): RecyclerView.Adapter<AdapterColorFull.HolderList>() {


    private var counter = 0

    abstract fun addToFavorite(font: Int, position: Int, iconLike : Int)
    abstract fun deleteFavorite(position: Int)

    inner class HolderList(item : View): RecyclerView.ViewHolder(item) {
        val imageFonts : ImageView = item.findViewById(R.id.imageViewFonts)
        val imageDiamondFonts : ImageView = item.findViewById(R.id.imageDiamondFonts)
        val imageLikesState : ImageView = item.findViewById(R.id.imageLikeState)

        fun bind(dataFonts: DataColorFull, position: Int) {
            imageFonts.setImageResource(dataFonts.fonts)
            imageLikesState.setImageResource(if (dataFonts.isFavorite)
                    R.drawable.ic_like_for_favorite
                else
                    R.drawable.ic_like_disabled)
            imageLikesState.setOnClickListener {
                counter++
                when(counter){
                    1 -> {
                        imageLikesState.setImageResource(R.drawable.ic_like_for_favorite)
                        addToFavorite(dataFonts.fonts, position, R.drawable.ic_like_for_favorite)
                    }
                    2 -> {
                        imageLikesState.setImageResource(R.drawable.ic_like_disabled)
                        deleteFavorite(position)
                        counter = 0
                    }
                }

            }

            itemView.setOnClickListener {
                Singleton.switchFragment(ViewAddingText())
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderList {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fonts_recycler_view, parent, false)
        return HolderList(view)
    }

    override fun onBindViewHolder(holder: HolderList, position: Int) {
        holder.bind(dataListFonts[position], position)

    }

    override fun getItemCount(): Int {
        return dataListFonts.size
    }


//    @SuppressLint("NotifyDataSetChanged")
//    fun deleteItem(index: Int) {
//        dataList.removeAt(index)
//        notifyDataSetChanged()
//    }
}