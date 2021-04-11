package com.mergenc.nasappcent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mergenc.nasappcent.R
import com.mergenc.nasappcent.model.ModelC
import kotlinx.android.synthetic.main.item_curiosity.view.*

class MarsAdapter(val marsList: ArrayList<ModelC>) :
    RecyclerView.Adapter<MarsAdapter.MarsViewHolder>() {

    class MarsViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_curiosity, parent, false)
        return MarsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return marsList.size
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        //holder.view.curiosityCamera.text = marsList[position].photos[position].camera.name
        holder.view.curiosityCamera.text = marsList[position].photos.camera.name

        //holder.view.imageCuriosity
    }

    // Refresh list;
    fun updateMarsList(newMarsList: List<ModelC>) {
        marsList.clear()
        marsList.addAll(newMarsList)
        notifyDataSetChanged()
    }

}