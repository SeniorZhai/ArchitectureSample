package io.github.seniorzhai.architecturesample.network

import android.arch.persistence.room.Entity

@Entity(primaryKeys = arrayOf("id"))
data class Story constructor(
        var images: Array<String>,
        var id: Long,
        var title: String)
