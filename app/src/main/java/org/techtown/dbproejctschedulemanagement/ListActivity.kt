package org.techtown.dbproejctschedulemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.techtown.dbproejctschedulemanagement.databinding.ActivityMainBinding

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val day = intent.getStringExtra("day")
        //이전 액티비티에서 날짜 가져오기

        val setDay : TextView = findViewById(R.id.day)
        setDay.setText(day+"일")



    }
}