package org.techtown.dbproejctschedulemanagement

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ListViewModel(application: Application) : AndroidViewModel(application){

    private val repository = ListRepository(application)
    private val list = repository.getAll()

    fun getAll() : LiveData<List<WorkList>>{
        return list
    }

    fun insert(list : WorkList){
        repository.insert(list)
    }

    fun delete(list : WorkList){
        repository.delete(list)
    }

    fun update(list : WorkList){
        repository.update(list)
    }


}