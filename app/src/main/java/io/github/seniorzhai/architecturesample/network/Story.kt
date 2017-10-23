package io.github.seniorzhai.architecturesample.network

import java.util.*

data class Story constructor(
        var images: Array<String>,
        var id: Long,
        var title: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Story

        if (!Arrays.equals(images, other.images)) return false
        if (id != other.id) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Arrays.hashCode(images)
        result = 31 * result + id.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}
