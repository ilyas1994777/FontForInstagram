package com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToClassic.adapterClassic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R

abstract class AdapterClassicFavorite(val listClassic : ArrayList<DataClassicFavorite>):
    RecyclerView.Adapter<AdapterClassicFavorite.HolderClassicFavorite>() {

    abstract fun delete(position: Int)

   inner class HolderClassicFavorite(item : View) : RecyclerView.ViewHolder(item) {
        val imageViewFavoriteClassic : ImageView = item.findViewById(R.id.imageViewFavoriteClassic)
        val imageDiamondFavoriteClassic : ImageView = item.findViewById(R.id.imageDiamondFavoriteClassic)
        val imageLikeStateFavoriteClassic : ImageView = item.findViewById(R.id.imageLikeStateFavoriteClassic)

        fun bind(dataClassicFavorite: DataClassicFavorite){
            imageViewFavoriteClassic.setImageResource(dataClassicFavorite.fonts)
            imageLikeStateFavoriteClassic.setImageResource(dataClassicFavorite.icon)

            imageLikeStateFavoriteClassic.setOnClickListener {
                delete(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClassicFavorite {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_classic_recycler, parent, false)
        return HolderClassicFavorite(item)
    }

    override fun onBindViewHolder(holder: HolderClassicFavorite, position: Int) {
        holder.bind(listClassic[position])
    }

    override fun getItemCount(): Int {
        return listClassic.size
    }
}