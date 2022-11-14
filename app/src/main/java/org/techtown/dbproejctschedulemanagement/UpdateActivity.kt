package org.techtown.dbproejctschedulemanagement

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.techtown.dbproejctschedulemanagement.databinding.ActivityUpdateBinding
import java.time.LocalDateTime

class UpdateActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityUpdateBinding
    private lateinit var model : ListViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val currentTime = LocalDateTime.now()

        var hour = currentTime.hour
        var min = currentTime.minute

        model = ViewModelProvider(this).get(ListViewModel::class.java)
        //viewModel 초기화



        val day : String? = intent.getStringExtra("day")
        //이전 액티비티에서 날짜 가져오기

        val id : Long = intent.getLongExtra("id",0)

        //TimePick 값 변경 이벤트
        mBinding.timePicker.setOnTimeChangedListener{timePicker,hourOfDay,minute ->

            hour = hourOfDay
            min = minute

        }

        mBinding.cancelButton.setOnClickListener {
            finish()
        }

        mBinding.updateButton.setOnClickListener {

            Toast.makeText(this,"일정 수정 완료", Toast.LENGTH_SHORT).show()

            var parsingDay : String? = day?.replace("년","")?.replace("월","")
                ?.replace("일","")?.replace(" ","")


            Log.e("TAG",parsingDay.toString())

            lifecycleScope.launch(Dispatchers.IO){
                with(model) { update(WorkList(id,parsingDay,mBinding.workText.text.toString(), "$hour"+"시 "+"$min"+"분")) }
            }

            finish()

        }

    }
}


