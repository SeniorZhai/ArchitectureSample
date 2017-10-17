package io.github.seniorzhai.architecturesample.persistence

import android.content.Context
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