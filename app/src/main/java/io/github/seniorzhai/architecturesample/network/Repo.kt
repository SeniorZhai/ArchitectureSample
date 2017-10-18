/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.seniorzhai.architecturesample.network

import android.arch.persistence.room.Embedded

import com.google.gson.annotations.SerializedName

data class Repo(val id: Int, @field:SerializedName("name")
val name: String, @field:SerializedName("full_name")
                val fullName: String, @field:SerializedName("description")
                val description: String, @field:SerializedName("owner")
                @field:Embedded(prefix = "owner_")
                val owner: Owner, @field:SerializedName("stargazers_count")
                val stars: Int) {

    class Owner(@field:SerializedName("login")
                val login: String, @field:SerializedName("url")
                val url: String?) {

        override fun equals(o: Any?): Boolean {
            if (this === o) {
                return true
            }
            if (o == null || javaClass != o.javaClass) {
                return false
            }

            val owner = o as Owner?

            if (if (login != null) login != owner!!.login else owner!!.login != null) {
                return false
            }
            return if (url != null) url == owner.url else owner.url == null
        }

        override fun hashCode(): Int {
            var result = login?.hashCode() ?: 0
            result = 31 * result + (url?.hashCode() ?: 0)
            return result
        }
    }
}
