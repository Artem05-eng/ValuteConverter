package com.example.testurrency.di

import androidx.room.Room
import com.example.testurrency.app.App
import com.example.testurrency.database.ValuteDao
import com.example.testurrency.database.ValuteDatabase
import com.example.testurrency.network.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@Module
class Module @Inject constructor(private val app: App) {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .followRedirects(false)
        .followSslRedirects(false)
        .build()

    @Singleton
    @Provides
    fun providesNetworkApi(okHttpClient: OkHttpClient): Api = Retrofit.Builder()
        .baseUrl("https://www.cbr-xml-daily.ru/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build().create()

    @Singleton
    @Provides
    fun providesDatabase(): ValuteDatabase = Room.databaseBuilder(
        app,
        ValuteDatabase::class.java,
        ValuteDatabase.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun providesDao(db: ValuteDatabase): ValuteDao = db.dao()
}