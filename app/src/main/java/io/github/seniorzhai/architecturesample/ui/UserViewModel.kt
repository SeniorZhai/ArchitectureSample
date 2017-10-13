package io.github.seniorzhai.architecturesample.ui

import android.arch.lifecycle.ViewModel
import io.github.seniorzhai.architecturesample.persistence.User
import io.github.seniorzhai.architecturesample.persistence.UserDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.functions.Action
import io.reactivex.internal.operators.completable.CompletableFromAction

class UserViewModel(private val dateSource: UserDao) : ViewModel() {
    fun uesrName(): Flowable<String> {
        return dateSource.getUserById(USER_ID).map { user -> user.userName }
    }

    fun updateUserName(userName: String): Completable {
        return CompletableFromAction(Action {
            val user = User(USER_ID, userName)
            dateSource.insertUser(user)
        })
    }

    companion object {
        const val USER_ID = "1"
    }
}