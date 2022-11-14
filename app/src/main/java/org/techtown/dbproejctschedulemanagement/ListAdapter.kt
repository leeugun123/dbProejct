package org.techtown.dbproejctschedulemanagement

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.techtown.dbproejctschedulemanagement.databinding.ListBinding

class ListAdapter(listener: ListActivity) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){

    private val item = ArrayList<WorkList>()
    private val mCallback = listener

    override fun getItemCount(): Int = item.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val mBinding = ListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(mBinding)
    }


    fun setList(list: List<WorkList>) {

        item.clear()
        item.addAll(list)
    }



    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {

        holder.bind(item[position])

    }

    inner class ViewHolder(private val binding: ListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WorkList?) {

            if (item != null) {
                binding.title.setText(item.title)
            }

            if (item != null) {
                binding.time.setText(item.time)
            }



        }




}