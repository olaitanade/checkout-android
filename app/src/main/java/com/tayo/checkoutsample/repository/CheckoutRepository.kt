package com.tayo.checkoutsample.repository

import com.tayo.checkoutsample.data.model.Cart
import com.tayo.checkoutsample.data.model.Item
import com.tayo.checkoutsample.data.model.Ticket

interface CheckoutRepository {
    fun getTickets(): List<Ticket>
    fun getTicket(id: String) : Ticket

    fun addToCart(item: Item)
    fun getCart(): Cart
}