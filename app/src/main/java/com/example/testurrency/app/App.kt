package com.example.testurrency.app

import android.app.Application
import com.example.testurrency.di.DaggerValuteComponent
import com.example.testurrency.di.Module
import com.example.testurrency.di.ValuteComponent

class App: Application() {

    lateinit var component: ValuteComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerValuteComponent.builder().module(Module(this)).build()
        component.inject(this)
    }
}