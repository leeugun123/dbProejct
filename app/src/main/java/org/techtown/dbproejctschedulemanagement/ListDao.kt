package org.techtown.dbproejctschedulemanagement

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ListDao {

    @Query("SELECT * FROM WorkList")
    fun getList() : LiveData<List<WorkList>>

    @Query("SELECT * FROM WorkList WHERE day = :day")
    fun getSelectedList(day : String) : LiveData<List<WorkList>>

    /*
    @Query("SELECT * FROM WorkList WHERE EXISTS (SELECT * FROM WorkList WHERE day = :day)")
    fun getSelectedListExist(day : String) : Boolean
    */

    @Delete
    fun deleteList(list : WorkList)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(workList : WorkList)

    @Update
    fun updateList(workList : WorkList)

}