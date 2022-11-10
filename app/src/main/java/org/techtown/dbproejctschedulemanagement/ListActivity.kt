package org.techtown.dbproejctschedulemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    private lateinit var adapter : ListAdapter
    private lateinit var model : ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val day = intent.getStringExtra("day")
        //이전 액티비티에서 날짜 가져오기

        val setDay : TextView = findViewById(R.id.day)
        setDay.setText(day+"일")

        val registerButton : Button = findViewById(R.id.registerButton)
        //등록 버튼

        var list : RecyclerView = findViewById(R.id.list)


        adapter = ListAdapter(this)
        list.adapter = adapter
        //recyclerView 초기화

        model = ViewModelProvider(this).get(ListViewModel::class.java)
        //viewModel 초기화


        with(model) {

            getAll().observe(this@ListActivity) { lists ->

                adapter.setList(lists)
                adapter.notifyDataSetChanged()

            }

        }


        registerButton.setOnClickListener {

            val intent = Intent(this,RegisterActivity::class.java)

            intent.putExtra("day",day)

            intent.run {
                this@ListActivity.startActivity(this)
            }

        }



    }
}