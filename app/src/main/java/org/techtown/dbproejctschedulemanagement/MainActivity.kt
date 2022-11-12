package org.techtown.dbproejctschedulemanagement

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.techtown.dbproejctschedulemanagement.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding

    //년월 변수
    lateinit var selectedDate: LocalDate

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding 초기화
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //현재날짜
        selectedDate = LocalDate.now()

        //화면 설정
        setMonthView()

        //이전달 버튼
        binding.preBtn.setOnClickListener {
            //현재 월 -1 변수 담기
            selectedDate = selectedDate.minusMonths(1)
            setMonthView()
        }

        //다음달 버튼
        binding.nextBtn.setOnClickListener {
            selectedDate = selectedDate.plusMonths(1)
            setMonthView()
        }

    }

    //날짜 화면에 보여주기
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setMonthView() {
        //년월 텍스트뷰 셋팅

        binding.monthYearText.text = monthYearFromDate(selectedDate)

        //날자 생성해서 리스트에 담기
        val dayList = dayInMonthArray(selectedDate)

        //어뎁터 초기화
        val adapter = CalendarAdapter(dayList,this)

        //레이아웃 설정(열 7개)
        var manager : RecyclerView.LayoutManager = GridLayoutManager(applicationContext,7)

        //레이아웃 적용
        binding.recyclerView.layoutManager = manager

        //어뎁터 적용
        binding.recyclerView.adapter = adapter
    }


    //날짜 타입 설정(월, 년)
    @RequiresApi(Build.VERSION_CODES.O)
    private fun monthYearFromDate(date: LocalDate) : String{

        var formatter = DateTimeFormatter.ofPattern("MM월 yyyy")

        //받아온 날짜를 해당 포맷으로 설정
        return date.format(formatter)
    }


    //날짜 타입
    @RequiresApi(Build.VERSION_CODES.O)
    private fun yearMonthFromDate(date: LocalDate) : String{

        var formatter = DateTimeFormatter.ofPattern("yyyy년 MM월")

        //받아온 날짜를 해당 포맷으로 설정
        return date.format(formatter)
    }

    //날짜 생성
    @RequiresApi(Build.VERSION_CODES.O)
    private fun dayInMonthArray(date : LocalDate): ArrayList<LocalDate?>{

        var dayList = ArrayList<LocalDate?>()

        var yearMonth = YearMonth.from(date)

        //해당 월 마지막 날짜 가져오기 ex) 28,30 31
        var lastDay = yearMonth.lengthOfMonth()

        //해당 월의 첫 번째 날 가져오기(예 4월 1일)
        var firstDay = selectedDate.withDayOfMonth(1)

        //첫번째날 요일 가져오기
        var dayOfWeek = firstDay.dayOfWeek.value




        for(i in 1..41){

            if(i <= dayOfWeek || i  > (lastDay + dayOfWeek)){
                dayList.add(null)
            }else{
                //년 월 일
                dayList.add(LocalDate.of(selectedDate.year,
                    selectedDate.monthValue, i-dayOfWeek))
            }

        }

        return dayList

    }




}