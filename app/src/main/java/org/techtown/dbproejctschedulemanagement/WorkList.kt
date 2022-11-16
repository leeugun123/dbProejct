package org.techtown.dbproejctschedulemanagement

import android.util.Log
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

    @ColumnInfo(name = "hour")
    val hour : Int?,
    //시

    @ColumnInfo(name = "minute")
    val minute : Int?,
    //분

    @ColumnInfo(name = "check")
    val check : Boolean?,
    //스케줄을 수행했는지 체크

) : Comparable<WorkList> {
    override fun compareTo(other: WorkList): Int {

        if(this.hour == other.hour){
            return this.minute!! - other.minute!!;
        }
        else
            return this.hour!! - other.hour!!;

    }

}
