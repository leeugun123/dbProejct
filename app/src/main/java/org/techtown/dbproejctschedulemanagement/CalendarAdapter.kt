package org.techtown.dbproejctschedulemanagement

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter(private val dayList: ArrayList<String>, private val
                onItemListener: OnItemListener,val context : Context) : RecyclerView.Adapter<CalendarAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val dayText : TextView = itemView.findViewById(R.id.dayText)

    }

    //화면 설정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_item,parent,false)

        return ItemViewHolder(view)


    }



    //데이터 설정
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //날짜 변수에 담기
        var day = dayList[holder.adapterPosition]


        holder.dayText.text = day

        //텍스트 색상 지정(토,일)
        if((position + 1) % 7 == 0){
            holder.dayText.setTextColor(Color.BLUE)
        }//토요일 -> 파란색
        else if(position == 0 || position % 7 == 0){
            holder.dayText.setTextColor(Color.RED)
        }//일요일은 빨강

        //날짜 클릭 이벤트
        holder.itemView.setOnClickListener {

            val intent = Intent(context,ListActivity::class.java)

            intent.putExtra("day",day)

            intent.run {
                context.startActivity(this)
            }

        }



    }



    override fun getItemCount(): Int {
        return dayList.size
    }



}