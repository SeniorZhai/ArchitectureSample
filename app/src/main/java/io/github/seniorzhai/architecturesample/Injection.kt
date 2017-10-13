package io.github.seniorzhai.architecturesample

import android.content.Context
import io.github.seniorzhai.architecturesample.persistence.UserDao
import io.github.seniorzhai.architecturesample.persistence.UsersDatabase
import io.github.seniorzhai.architecturesample.ui.ViewModelFactory

object Injection {
    fun provideUserDataSource(context: Context): UserDao {
        val database = UsersDatabase.getInstance(context)
        return database.userDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return ViewModelFactory(dataSource)
    }
}