package io.github.seniorzhai.architecturesample.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(User::class), version = 1)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile private var INSTANCE: UsersDatabase? = null

        // also 讲某个对象 以it参数传入闭包
        fun getInstance(context: Context): UsersDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        UsersDatabase::class.java, "Sample.db")
                        .build()

    }

    /*
        run 实例执行一个闭包，最后一行为返回值
        var a = 2.run {
            this + 2
        }
        apply 实例执行一个闭包
        var a = 1.apply{
            print(this)
        }
        let 实例执行一个闭包，最后一行为返回值，通过it访问本身
        var a = 1.let{
            it.plus(2)
        }
        with 某对象作为函数的参数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式
        var a = with(1){
            this.plus(2)
            this.toString()
        }
        // a = "3"
    */

}