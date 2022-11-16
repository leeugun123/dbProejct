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
    val time : String?,
    //시간

    @ColumnInfo(name = "check")
    val check : Boolean?,
    //스케줄을 수행했는지 체크

) : Comparable<WorkList> {
    override fun compareTo(other: WorkList): Int {

        return Integer.parseInt(other.day?.replace("시","")!!.replace("분",""))-Integer.parseInt(
            this.day?.replace("시","")!!.replace("분",""))
    }

}
