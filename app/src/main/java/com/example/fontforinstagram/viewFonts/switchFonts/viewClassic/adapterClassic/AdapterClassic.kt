package com.example.fontforinstagram.viewFonts.switchFonts.viewClassic.adapterClassic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R

abstract class AdapterClassic(var dataListClassic: ArrayList<DataClassic>): RecyclerView.Adapter<AdapterClassic.HolderList>() {




    inner class HolderList(item : View): RecyclerView.ViewHolder(item) {
        val imageViewFontsClassic : ImageView = item.findViewById(R.id.imageViewFontsClassic)
        val imageDiamondClassic : ImageView = item.findViewById(R.id.imageDiamondClassic)
        val imageLikeStateClassic : ImageView = item.findViewById(R.id.imageLikeStateClassic)

        fun bind(dataClassic: DataClassic, position: Int) {
            imageViewFontsClassic.setImageResource(dataClassic.fonts!!)

            imageLikeStateClassic.setOnClickListener {

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