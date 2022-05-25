package com.tayo.checkoutsample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tayo.checkoutsample.data.model.Cart
import com.tayo.checkoutsample.repository.CheckoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val checkoutRepository: CheckoutRepository
): ViewModel() {
    private val _itemsModel = MutableLiveData<Cart>()
    val itemsModel: LiveData<Cart> = _itemsModel

    fun getCart() {
        _itemsModel.value = checkoutRepository.getCart()
    }
}