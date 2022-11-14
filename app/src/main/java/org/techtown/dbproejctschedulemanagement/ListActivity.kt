package org.techtown.dbproejctschedulemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*
import org.techtown.dbproejctschedulemanagement.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityListBinding
    private lateinit var adapter : ListAdapter
    private lateinit var model : ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        val day = intent.getStringExtra("day")
        //이전 액티비티에서 날짜 가져오기


        mBinding.day.setText(day)


        adapter = ListAdapter(this)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
        //recyclerView 초기화

        model = ViewModelProvider(this).get(ListViewModel::class.java)
        //viewModel 초기화


        with(model) {

            getAll().observe(this@ListActivity) { lists ->

                adapter.setList(lists)
                adapter.notifyDataSetChanged()

            }

        }


        mBinding.registerButton.setOnClickListener {

            val intent = Intent(this,RegisterActivity::class.java)

            intent.putExtra("day",day)

            intent.run {
                this@ListActivity.startActivity(this)
            }

        }

        mBinding.cancelButton.setOnClickListener {
            finish()
        }



    }
}