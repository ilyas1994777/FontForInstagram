package com.example.fontforinstagram.viewLikes.favoriteStickers.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.ViewStartWindowStickers.IViewStickers

abstract class AdapterFavoriteStickers(val imageList : ArrayList<DataFavorite>): RecyclerView.Adapter<AdapterFavoriteStickers.HolderFavoriteStickers>() {

    abstract fun getPosition(position : Int)
    abstract fun deletePosition(position: Int)
    inner class HolderFavoriteStickers(item : View): RecyclerView.ViewHolder(item)  {
        val imageViewFavoriteStickers : ImageView = item.findViewById(R.id.imageViewFavoriteStickers)
        val imageDiamondFavoriteStickers : ImageView = item.findViewById(R.id.imageDiamondFavoriteStickers)
        val imageLikeStateFavoriteStickers : ImageView = item.findViewById(R.id.imageLikeStateFavoriteStickers)

        fun bind(dataFavorite: DataFavorite, position: Int){
            imageViewFavoriteStickers.setImageResource(dataFavorite.imageSticker)
            imageLikeStateFavoriteStickers.setImageResource(dataFavorite.iconLike)


            imageLikeStateFavoriteStickers.setOnClickListener {
                deletePosition(position)
            }
        }


    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderFavoriteStickers {
         val item = LayoutInflater.from(parent.context).inflate(
             R.layout.item_favorite_stickers_recycler, parent, false)
         return HolderFavoriteStickers(item)
     }

     override fun onBindViewHolder(holder: HolderFavoriteStickers, position: Int) {
        holder.bind(imageList[position], position)
     }

     override fun getItemCount(): Int {
        return imageList.size
     }

 }