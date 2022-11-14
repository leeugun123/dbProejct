package org.techtown.dbproejctschedulemanagement

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
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

            val listArray : Array<String> = arrayOf("수정","삭제")

            if (item != null) {
                binding.title.setText(item.title)
            }//스케줄 제목

            if (item != null) {
                binding.time.setText(item.time)
            }//시간

            itemView.setOnClickListener {

                val builder = AlertDialog.Builder(itemView.context)

                builder.setTitle("기능 선택")
                    .setItems(listArray
                        ,DialogInterface.OnClickListener{dialogInterface, i ->

                            if(i == 0){
                                Toast.makeText(itemView.context,"수정",Toast.LENGTH_SHORT).show()



                            }
                            else if(i == 1){
                                Toast.makeText(itemView.context,"삭제 되었습니다.",Toast.LENGTH_SHORT).show()

                                if (item != null) {
                                    mCallback.deleteList(item)
                                }

                            }

                        })


                builder.show()
                //다이얼로그 띄어주기

            }



        }


    }




}