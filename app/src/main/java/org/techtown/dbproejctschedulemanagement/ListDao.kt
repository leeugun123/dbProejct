package org.techtown.dbproejctschedulemanagement

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ListDao {

    @Query("SELECT * FROM WorkList")
    fun getList() : LiveData<List<WorkList>>

    @Delete
    fun deleteList(list : WorkList)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(workList : WorkList)

    @Update
    fun updateList(workList : WorkList)

}