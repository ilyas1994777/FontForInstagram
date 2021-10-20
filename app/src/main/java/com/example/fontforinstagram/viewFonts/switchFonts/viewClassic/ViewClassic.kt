package com.example.fontforinstagram.viewFonts.switchFonts.viewClassic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fontforinstagram.R
import com.example.fontforinstagram.repository.SingletonRepository
import com.example.fontforinstagram.repository.room.FavoriteFonts
import com.example.fontforinstagram.repository.room.FontsDao
import com.example.fontforinstagram.viewFonts.switchFonts.viewClassic.adapterClassic.AdapterClassic
import com.example.fontforinstagram.viewFonts.switchFonts.viewClassic.adapterClassic.DataClassic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewClassic : Fragment() {

    private var recyclerView : RecyclerView? = null
    private var mutListClassic : ArrayList<DataClassic> = arrayListOf()
    lateinit var fontDao : FontsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_classic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerClassic)
        fontDao = SingletonRepository.dataBaseFonts(requireContext()).fontsDao()
        mutListClassic.add(DataClassic(R.drawable.ic_yesterday_without_shadow))





//        recyclerView!!.adapter = adapterClassic
        recyclerView!!.layoutManager = LinearLayoutManager(context)
    }
}