package org.techtown.dbproejctschedulemanagement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(listener: ListActivity) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>(){

    private val item = ArrayList<WorkList>()
    private val mCallback = listener

    override fun getItemCount(): Int = item.size

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.title)
        val time : TextView = itemView.findViewById(R.id.time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list,parent,false)

        return ItemViewHolder(view)


    }


    fun setList(list: List<WorkList>) {

        item.clear()
        item.addAll(list)
    }



    override fun onBindViewHolder(holder: ListAdapter.ItemViewHolder, position: Int) {

        holder.title.text = item.get(holder.adapterPosition).title
        holder.time.text = item.get(holder.adapterPosition).time

    }




}