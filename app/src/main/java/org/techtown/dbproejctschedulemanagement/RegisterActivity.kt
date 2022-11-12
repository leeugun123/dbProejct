package org.techtown.dbproejctschedulemanagement

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class RegisterActivity : AppCompatActivity() {

    private lateinit var model : ListViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val currentTime = LocalDateTime.now()

        var hour = currentTime.hour
        var min = currentTime.minute

        val timePicker : TimePicker = findViewById(R.id.timePicker)//시간
        val titleText : EditText = findViewById(R.id.workText)//제목
        val cancelButton : Button = findViewById(R.id.cancel_button)//취소 버튼
        val registerButton : Button = findViewById(R.id.save_button)//저장 버튼

        model = ViewModelProvider(this).get(ListViewModel::class.java)
        //viewModel 초기화

        val day : String? = intent.getStringExtra("day")
        //이전 액티비티에서 날짜 가져오기

        //TimePick 값 변경 이벤트
        timePicker.setOnTimeChangedListener{timePicker,hourOfDay,minute ->

            hour = hourOfDay
            min = minute

        }


        cancelButton.setOnClickListener {
            finish()
        }

        registerButton.setOnClickListener {

            Toast.makeText(this,"일정 등록 완료",Toast.LENGTH_SHORT).show()

            lifecycleScope.launch(Dispatchers.IO){
                with(model) { insert(WorkList(0,day,titleText.text.toString(), "$hour"+"시 "+"$min"+"분")) }
            }

            finish()

        }




    }
}