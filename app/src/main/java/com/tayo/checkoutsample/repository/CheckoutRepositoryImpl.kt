package com.tayo.checkoutsample.repository

import com.tayo.checkoutsample.data.model.Cart
import com.tayo.checkoutsample.data.model.Item
import com.tayo.checkoutsample.data.model.Ticket
import javax.inject.Inject

class CheckoutRepositoryImpl @Inject constructor(
    private val tickets: ArrayList<Ticket>
): CheckoutRepository {
    override fun getTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getTicket(id: String): Ticket {
        TODO("Not yet implemented")
    }

    override fun addToCart(item: Item) {
        TODO("Not yet implemented")
    }

    override fun getCart(): Cart {
        TODO("Not yet implemented")
    }

}