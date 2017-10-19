package io.github.seniorzhai.architecturesample.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by zhai on 2017/10/19.
 */

@Dao
abstract class StoryDao {
    @Query("SELECT * FROM story WHERE id = :id")
    abstract fun getStoryById(id: Long): DbStory

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertStory(story: DbStory)
}
