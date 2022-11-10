package org.techtown.dbproejctschedulemanagement

import android.app.Application
import androidx.lifecycle.LiveData

class ListRepository (application: Application){

    private val listDao : ListDao
    private val list : LiveData<List<WorkList>>

    init {

        var db = ListDatabase.getInstance(application)

        listDao = db!!.listDao()
        list = db.listDao().getList()

    }

    fun insert(list : WorkList){
        listDao.insertList(list)
    }

    fun getAll() : LiveData<List<WorkList>>{
        return listDao.getList()
    }

    fun delete(list : WorkList){
        listDao.deleteList(list)
    }

    fun update(list : WorkList){
        listDao.updateList(list)
    }


}