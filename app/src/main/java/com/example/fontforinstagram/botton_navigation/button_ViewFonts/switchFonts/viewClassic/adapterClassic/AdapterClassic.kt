package com.example.fontforinstagram.botton_navigation.button_ViewFonts.switchFonts.viewClassic.adapterClassic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R

abstract class AdapterClassic(var dataListClassic: ArrayList<DataClassic>): RecyclerView.Adapter<AdapterClassic.HolderList>() {

    abstract fun addToFavorite(position : Int, image: Int, icon_like : Int)
    abstract fun deletePosition(position: Int)

    private var counter = 0

    inner class HolderList(item : View): RecyclerView.ViewHolder(item) {
        val imageViewFontsClassic : ImageView = item.findViewById(R.id.imageViewFontsClassic)
        val imageDiamondClassic : ImageView = item.findViewById(R.id.imageDiamondClassic)
        val imageLikeStateClassic : ImageView = item.findViewById(R.id.imageLikeStateClassic)

        fun bind(dataClassic: DataClassic, position: Int) {
            imageViewFontsClassic.setImageResource(dataClassic.fonts!!)
            imageLikeStateClassic.setImageResource(
                if (dataClassic.isFavorite)
                    R.drawable.ic_like_for_favorite
            else  R.drawable.ic_like_disabled)


            imageLikeStateClassic.setOnClickListener {
                counter++
                if (counter == 1) {
                    imageLikeStateClassic.setImageResource(R.drawable.ic_like_for_favorite)
                    addToFavorite(
                        dataClassic.id,
                        dataClassic.fonts,
                        R.drawable.ic_like_for_favorite
                    )
                }
                if (counter == 2){
                    imageLikeStateClassic.setImageResource(R.drawable.ic_like_disabled)
                    deletePosition(position)
                    counter = 0
                }
            }

            itemView.setOnClickListener {

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderList {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_classic_recycler_view, parent, false)
        return HolderList(view)
    }

    override fun onBindViewHolder(holder: HolderList, position: Int) {
        holder.bind(dataListClassic[position], position)

    }

    override fun getItemCount(): Int {
        return dataListClassic.size
    }


//    @SuppressLint("NotifyDataSetChanged")
//    fun deleteItem(index: Int) {
//        dataList.removeAt(index)
//        notifyDataSetChanged()
//    }
}