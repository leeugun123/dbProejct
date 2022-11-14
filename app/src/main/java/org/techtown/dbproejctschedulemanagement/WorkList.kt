package org.techtown.dbproejctschedulemanagement

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WorkList")
data class WorkList(

    @PrimaryKey(autoGenerate = true)
    var id : Long,

    @ColumnInfo(name = "day")
    var day : String?,
    //스케줄 날짜

    @ColumnInfo(name = "title")
    val title : String?,
    //할일

    @ColumnInfo(name = "time")
    val time : String?
    //시간

)
