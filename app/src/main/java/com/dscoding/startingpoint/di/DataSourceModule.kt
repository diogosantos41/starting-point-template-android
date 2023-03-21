package com.dscoding.startingpoint.di

import android.app.Application
import androidx.room.Room
import com.dscoding.startingpoint.common.Constants
import com.dscoding.startingpoint.data.data_source.ContactDatabase
import com.dscoding.startingpoint.data.repository.DbRepositoryImpl
import com.dscoding.startingpoint.domain.repository.DbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideContactDatabase(app: Application): ContactDatabase {
        return Room.databaseBuilder(app, ContactDatabase::class.java, Constants.CONTACT_DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideContactRepository(db: ContactDatabase): DbRepository {
        return DbRepositoryImpl(db.contactDao)
    }
}