package com.example.testurrency.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testurrency.data.Money

@Database(entities = [Money::class], version = ValuteDatabase.DB_VERSION)
abstract class ValuteDatabase: RoomDatabase() {

    abstract fun dao(): ValuteDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "valute-database"
    }

}