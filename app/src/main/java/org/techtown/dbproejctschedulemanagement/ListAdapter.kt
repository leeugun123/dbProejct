package org.techtown.dbproejctschedulemanagement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val onItemListener: OnItemListener,val context : Context) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>(){

    private val list = ArrayList<WorkList>()
    private val mCallback = onItemListener

    override fun getItemCount(): Int = list.size

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.title)
        val time : TextView = itemView.findViewById(R.id.time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list,parent,false)

        return ItemViewHolder(view)


    }

    override fun onBindViewHolder(holder: ListAdapter.ItemViewHolder, position: Int) {







    }




}