package com.example.onlinestore.presentation.mainpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.domain.models.DefValue
import com.example.onlinestore.domain.usecase.ClickFreeShipUseCase
import com.example.onlinestore.domain.usecase.ClickSearchUseCase
import com.example.onlinestore.domain.usecase.ScrollToBottomUseCase
import com.example.onlinestore.presentation.mainpage.MainPageActivity

class MainViewModel(
    private val clickSearch: ClickSearchUseCase,
    private val clickFreeShip: ClickFreeShipUseCase,
    private val scrollToBottom: ScrollToBottomUseCase

): ViewModel() {

    private val _items = MutableLiveData<DefValue>()
    val items: LiveData<DefValue> get() = _items

    fun click(binding: ActivityMainPageBinding, activity: MainPageActivity) {
        clickSearch.clickSearch(binding, activity)
    }

    fun scroll(binding: ActivityMainPageBinding, activity: MainPageActivity, dy: Int) {
        scrollToBottom.scrollToBottom(binding,activity, dy)
    }

    fun clickFreeShip(binding: ActivityMainPageBinding, activity: MainPageActivity) {
        clickFreeShip.clickFreeShip(binding, activity)
    }

    fun updateViewState(newState: DefValue) {
        _items.value = newState
    }
}