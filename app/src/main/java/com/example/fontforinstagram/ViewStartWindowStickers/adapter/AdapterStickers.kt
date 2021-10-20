package com.example.fontforinstagram.ViewStartWindowStickers.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R

abstract class AdapterStickers(var dataList: ArrayList<DataStickersModelView>): RecyclerView.Adapter<AdapterStickers.HolderList>() {



    abstract fun position(position: Int)


    inner class HolderList(item : View): RecyclerView.ViewHolder(item) {
        val textViewStickerName : TextView = item.findViewById(R.id.textViewStickerName)
        val imageStickersFirstImage : ImageView = item.findViewById(R.id.imageStickersFirstImage)
        val imageStickersSecondImage : ImageView = item.findViewById(R.id.imageStickersSecondImage)
        val imageStickersThirdImage : ImageView = item.findViewById(R.id.imageStickersThirdImage)

        fun bind(dataStickersModelView: DataStickersModelView, position: Int) {
            textViewStickerName.text = dataStickersModelView.textViewStickerName
            imageStickersFirstImage.setImageResource(dataStickersModelView.imageStickersFirstImage!!)
            imageStickersSecondImage.setImageResource(dataStickersModelView.imageStickersSecondImage!!)
            imageStickersThirdImage.setImageResource(dataStickersModelView.imageStickersThirdImage!!)


            itemView.setOnClickListener {
                position(position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderList {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stickers_recycler_view, parent, false)
        return HolderList(view)
    }

    override fun onBindViewHolder(holder: HolderList, position: Int) {
        holder.bind(dataList[position], position)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


//    @SuppressLint("NotifyDataSetChanged")
//    fun deleteItem(index: Int) {
//        dataList.removeAt(index)
//        notifyDataSetChanged()
//    }
}