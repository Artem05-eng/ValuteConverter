package com.example.testurrency.di

import com.example.testurrency.CalculateFragment
import com.example.testurrency.CurrencyFragment
import com.example.testurrency.MainActivity
import com.example.testurrency.app.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Module::class, RepoModule::class])
interface ValuteComponent {
    fun inject(app: App)
    fun inject(fragment: CurrencyFragment)
    fun inject(fragment: CalculateFragment)
}