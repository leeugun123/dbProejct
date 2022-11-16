package org.techtown.dbproejctschedulemanagement

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.dbproejctschedulemanagement.databinding.ListBinding
import java.util.*
import kotlin.collections.ArrayList

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

        if(!list.isEmpty())
            Collections.sort(list)

        item.addAll(list)
    }


    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {

        holder.bind(item[position])

    }

    inner class ViewHolder(private val binding: ListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WorkList?) {

            val listArray : Array<String> = arrayOf("수정","삭제","작업 완료")

            if (item != null) {
                binding.title.setText(item.title)
            }//스케줄 제목

            if (item != null) {
                binding.time.setText(item.hour.toString()+"시 "+ item.minute+"분")
            }//시간

            if(item != null){

                if(item.check == false){
                    binding.checkImg.setImageResource(R.drawable.clear_img)
                }
                else{
                    binding.checkImg.setImageResource(R.drawable.check_img)
                }

            }//완료 여부


            itemView.setOnClickListener {

                val builder = AlertDialog.Builder(itemView.context)

                builder.setTitle("기능 선택")
                    .setItems(listArray
                        ,DialogInterface.OnClickListener{dialogInterface, i ->

                            if(i == 0){

                                val intent = Intent(itemView.context,UpdateActivity::class.java)

                                if (item != null) {

                                    intent.putExtra("id",item.id)
                                    intent.putExtra("day",item.day)
                                    intent.putExtra("title",item.title)
                                    intent.putExtra("hour",item.hour)
                                    intent.putExtra("minute",item.minute)
                                    intent.putExtra("check",item.check)

                                }

                                intent.run {
                                    itemView.context.startActivity(this)
                                }



                            }//수정
                            else if(i == 1){

                                Toast.makeText(itemView.context,"삭제 되었습니다.",Toast.LENGTH_SHORT).show()

                                if (item != null) {
                                    mCallback.deleteList(item)
                                }

                            }
                            else if(i == 2){

                                if (item != null) {
                                    mCallback.updateList(WorkList(item.id,item.day,item.title, item.hour,item.minute ,true))

                                    Toast.makeText(itemView.context,"일정을 수행하였습니다.",Toast.LENGTH_SHORT).show()

                                }
                            }

                        })


                builder.show()
                //다이얼로그 띄어주기

            }



        }


    }




}