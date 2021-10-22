package com.example.fontforinstagram.botton_navigation.button_ViewLikesEqualFavorite.switchToColorful.adapterColorFul

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R

abstract class AdapterColorFul(val list : ArrayList<DataColorfulFavorite>) : RecyclerView.Adapter<AdapterColorFul.HolderColorFul>() {

    abstract fun deleteFont(position: Int)

   inner class HolderColorFul(item : View): RecyclerView.ViewHolder(item) {
            val imageViewFontColorfulFavorite : ImageView = item.findViewById(R.id.imageViewFontColorfulFavorite)
            val imageDiamondColorfulFavorite : ImageView = item.findViewById(R.id.imageDiamondColorfulFavorite)
            val imageLikeColorfulFavorite : ImageView = item.findViewById(R.id.imageLikeColorfulFavorite)

        fun bind(dataColorfulFavorite: DataColorfulFavorite){
            imageViewFontColorfulFavorite.setImageResource(dataColorfulFavorite.fonts)
            imageLikeColorfulFavorite.setImageResource(dataColorfulFavorite.icon)

            imageLikeColorfulFavorite.setOnClickListener {
                deleteFont(position)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderColorFul {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_like_colorful, parent, false)
        return HolderColorFul(item)
    }

    override fun onBindViewHolder(holder: HolderColorFul, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}