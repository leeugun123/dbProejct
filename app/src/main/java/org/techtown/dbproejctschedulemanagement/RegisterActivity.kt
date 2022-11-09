package org.techtown.dbproejctschedulemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val timePicker : TimePicker = findViewById(R.id.timePicker)//시간
        val titleText : EditText = findViewById(R.id.workText)//제목
        val cancelButton : Button = findViewById(R.id.cancel_button)//취소 버튼
        val registerButton : Button = findViewById(R.id.register_button)//등록 버튼






    }
}