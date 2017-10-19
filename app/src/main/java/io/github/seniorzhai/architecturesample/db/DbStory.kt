package io.github.seniorzhai.architecturesample.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.github.seniorzhai.architecturesample.network.Story

@Entity(tableName = "story")
data class DbStory constructor(
        var image: String,
        @PrimaryKey var id: Long,
        var title: String) {
    constructor(story: Story) : this(
            image = (
                    if (story.images.isEmpty()) {
                        ""
                    } else {
                        story.images[0]
                    }),
            id = story.id, title = story.title)
}