package com.example.littlelemon

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
class MenuNetwork(
    @SerialName("menu") val menu: List<MenuItemNetwork>
)

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class MenuItemNetwork(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("price") val price: String,
    @SerialName("image") val image: String,
    @SerialName("category") val category: String,
)