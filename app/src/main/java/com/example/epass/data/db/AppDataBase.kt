package com.example.epass.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.epass.domain.Pass

@Database(entities = [Pass::class],
            version = 1
)
abstract class AppDataBase  : RoomDatabase()
{
    abstract fun passDao() : DAO

    companion object{
        @Volatile
        var INSTANCE : AppDataBase?  = null
        fun getAppDB(context: Context) : AppDataBase?
        {
            INSTANCE ?:

            synchronized( AppDataBase::class) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDataBase::class.java,
                    "my_pass.db"
                ).build()
            }

            return INSTANCE
        }

        // destroy the DB
        fun destroyDataBase() {
            INSTANCE = null
        }
    }


}