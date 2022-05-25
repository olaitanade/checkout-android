package com.tayo.checkoutsample.data.model

data class Cart(
    val id: String,
    val subTotal: Double,
    val items: List<Item>,
)
