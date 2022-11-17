package org.techtown.dbproejctschedulemanagement

import androidx.lifecycle.LiveData

interface OnItemClick {

    fun updateList(list : WorkList)

    fun deleteList(list : WorkList)



}