package com.example.testurrency.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testurrency.data.Money

@Dao
interface ValuteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDataToDB(data: List<Money>)

    @Query("SELECT * FROM money")
    suspend fun getDataFromDB(): List<Money>

}