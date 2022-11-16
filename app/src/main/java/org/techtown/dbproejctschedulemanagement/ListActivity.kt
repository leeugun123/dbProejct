package org.techtown.dbproejctschedulemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.techtown.dbproejctschedulemanagement.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() , OnItemClick{

    private lateinit var mBinding : ActivityListBinding
    private lateinit var adapter : ListAdapter
    private lateinit var model : ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        var day = intent.getStringExtra("day")
        //이전 액티비티에서 날짜 가져오기


        mBinding.day.setText(day+" 일정")


        day = day?.replace("년","")?.replace("월","")
            ?.replace("일","")?.replace(" ","")

        adapter = ListAdapter(this)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
        //recyclerView 초기화

        model = ViewModelProvider(this).get(ListViewModel::class.java)
        //viewModel 초기화


        with(model) {

            if (day != null) {
                getSelectedList(day).observe(this@ListActivity) { lists ->

                    adapter.setList(lists)
                    adapter.notifyDataSetChanged()

                }
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

    override fun updateList(list: WorkList) {

        lifecycleScope.launch(Dispatchers.IO){
            model.update(list)
        }

    }

    override fun deleteList(list: WorkList) {

        lifecycleScope.launch(Dispatchers.IO){
            model.delete(list)
        }

    }


}