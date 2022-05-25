package com.tayo.checkoutsample.repository

import com.tayo.checkoutsample.data.model.Cart
import com.tayo.checkoutsample.data.model.Item
import com.tayo.checkoutsample.data.model.Ticket
import javax.inject.Inject

class CheckoutRepositoryImpl @Inject constructor(
    private val tickets: ArrayList<Ticket>
): CheckoutRepository {
    override fun getTickets(): List<Ticket> = tickets

    override fun getTicket(id: String): Ticket = tickets.first { ticket -> ticket.id == id }

    override fun addToCart(item: Item) {

    }

    override fun getCart(): Cart = Cart(
            id = "1",
            subTotal = tickets.sumOf { ticket -> ticket.price },
            items = tickets.map { ticket ->  Item(ticket.id,ticket,2)}
        )


}