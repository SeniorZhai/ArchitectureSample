package io.github.seniorzhai.architecturesample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by zhai on 2017/10/19.
 */

@Database(entities = arrayOf(DbStory::class), version = 1)
abstract class ZhihuDb : RoomDatabase() {
    abstract fun storyDao(): StoryDao
}
