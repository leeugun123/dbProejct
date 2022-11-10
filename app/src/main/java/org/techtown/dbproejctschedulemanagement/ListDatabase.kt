package org.techtown.dbproejctschedulemanagement

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [WorkList::class],
    version = 2,
    exportSchema = true
)

abstract class ListDatabase : RoomDatabase() {

    abstract fun listDao() : ListDao

    companion object{

        private var instance : ListDatabase? = null

        @Synchronized
        fun getInstance(context : Context) : ListDatabase?{

            if(instance == null){

                synchronized(ListDatabase::class){

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ListDatabase::class.java,
                        "list-database"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

                }


            }

            return instance
        }


    }

}