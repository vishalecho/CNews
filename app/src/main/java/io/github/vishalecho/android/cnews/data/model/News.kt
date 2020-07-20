package io.github.vishalecho.android.cnews.data.model

import com.google.gson.annotations.SerializedName

data class News (
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("banner_url")
    val banner_url: String,

    @SerializedName("time_created")
    val time_created: Long,

    @SerializedName("rank")
    val rank: Int
)