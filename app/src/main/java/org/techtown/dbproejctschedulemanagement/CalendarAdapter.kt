package org.techtown.dbproejctschedulemanagement

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class CalendarAdapter(private val dayList: ArrayList<LocalDate?>, val context : Context, listener: MainActivity) : RecyclerView.Adapter<CalendarAdapter.ItemViewHolder>() {

    private val mCallback = listener

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val dayText : TextView = itemView.findViewById(R.id.dayText)
        val checkWork : ImageView = itemView.findViewById(R.id.check_img)

    }

    //화면 설정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_item,parent,false)

        return ItemViewHolder(view)


    }


    //데이터 설정
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //날짜 변수에 담기
        var day = dayList[holder.adapterPosition]

        if(day == null){
            holder.dayText.text = ""
        }else{
            //해당 일자를 넣는다.
            holder.dayText.text = day.dayOfMonth.toString()

            //현재 날짜 색상 칠하기
            if(day == CalendarUtil.selectedDate){
                holder.itemView.setBackgroundColor(Color.LTGRAY)
            }

        }

        //텍스트 색상 지정(토,일)
        if((position + 1) % 7 == 0){
            holder.dayText.setTextColor(Color.BLUE)
        }//토요일 -> 파란색
        else if(position == 0 || position % 7 == 0){
            holder.dayText.setTextColor(Color.RED)
        }//일요일은 빨강





        var iYear = day?.year
        var iMonth = day?.monthValue
        var iDay = day?.dayOfMonth
        //년 , 달 , 일


        if(mCallback.getSelectedList(day.toString().replace("-","")))
            holder.checkWork.setImageResource(R.drawable.check_img)
        //일정이 있는지 체크해주는 imageView


        //날짜 클릭 이벤트
        holder.itemView.setOnClickListener {

            val intent = Intent(context,ListActivity::class.java)


            var yearmonDay = "$iYear"+"년 "+"$iMonth"+"월 "+"$iDay"+"일"

            intent.putExtra("day",yearmonDay)

            intent.run {
                context.startActivity(this)
            }

        }



    }



    override fun getItemCount(): Int {
        return dayList.size
    }



}