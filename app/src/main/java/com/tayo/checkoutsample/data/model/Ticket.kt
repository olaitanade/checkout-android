package com.tayo.checkoutsample.data.model

import java.util.*

data class Ticket(
    val id: String,
    val datetime: String,
    val name: String,
    val price: Double,
    val pictureURL: String
)
