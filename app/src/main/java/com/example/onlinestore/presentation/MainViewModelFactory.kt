package com.example.onlinestore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinestore.domain.models.DefValue
import com.example.onlinestore.domain.usecase.ClickFreeShipUseCase
import com.example.onlinestore.domain.usecase.ClickSearchUseCase
import com.example.onlinestore.domain.usecase.ScrollToBottomUseCase


class MainViewModelFactory: ViewModelProvider.Factory {

    private val defValue = DefValue()
    private val clickSearch = ClickSearchUseCase(defValue)
    private val clickFreeShip = ClickFreeShipUseCase(defValue)
    private val scrollToBottom = ScrollToBottomUseCase(defValue)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            clickSearch,
            clickFreeShip,
            scrollToBottom
        ) as T
    }

}