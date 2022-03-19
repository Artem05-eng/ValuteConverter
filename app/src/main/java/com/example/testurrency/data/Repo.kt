package com.example.testurrency.data

import com.example.testurrency.valuteToList

interface Repo {

    suspend fun getValuteFromNetwork(): List<Money>

    suspend fun getValuteFromDB(): List<Money>

    suspend fun saveValuteToDB(data: List<Money>)

}