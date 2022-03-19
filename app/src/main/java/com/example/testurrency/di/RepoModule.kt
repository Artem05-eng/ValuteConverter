package com.example.testurrency.di

import com.example.testurrency.data.Repo
import com.example.testurrency.data.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class RepoModule {

    @Binds
    abstract fun getRepository(repo: Repository): Repo
}