package com.tayo.checkoutsample.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tayo.checkoutsample.data.model.Item
import com.tayo.checkoutsample.databinding.TicketListItemLayoutBinding
import java.text.SimpleDateFormat

class ItemRecyclerViewAdapter constructor(
    private val dataList: MutableList<Item> = mutableListOf(),
    private val onClickListener: (Item) -> Unit,
) : RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = TicketListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        dataList[position].let { holder.setData(it) }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: List<Item>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val binding: TicketListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SimpleDateFormat")
        fun formatDate(inputDate: String): String? {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("EEE, d MMM yyyy HH:mm Z")
            return formatter.format(parser.parse(inputDate))
        }

        fun setData(model: Item) {
            binding.name.text = model.ticket.name
            binding.date.text = formatDate(model.ticket.datetime)
            binding.no.text = "${model.number} tickets"
            binding.price.text = "$${model.ticket.price} each"
        }

    }
}