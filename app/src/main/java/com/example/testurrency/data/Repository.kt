package com.example.testurrency.data

import com.example.testurrency.database.ValuteDao
import com.example.testurrency.network.Api
import com.example.testurrency.valuteToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(
    private val network: Api,
    private val db: ValuteDao
): Repo {

    override suspend fun getValuteFromNetwork(): List<Money> {
        return valuteToList(network.getValuteValues().Valute)
    }

    override suspend fun getValuteFromDB(): List<Money> {
        return db.getDataFromDB()
    }

    override suspend fun saveValuteToDB(data: List<Money>) {
        db.saveDataToDB(data)
    }

}