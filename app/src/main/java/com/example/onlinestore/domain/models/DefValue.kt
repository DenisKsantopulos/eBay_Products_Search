package com.example.onlinestore.domain.models

import com.example.onlinestore.data.remote.models.ItemSummary
import com.example.onlinestore.domain.utils.CreateToast
import com.example.onlinestore.domain.utils.FindItem

class DefValue {
    //private val defValue = DefValue()

    var isLoading = false
    var noMoreItems = false
    var listOfItems: MutableList<ItemSummary> = ArrayList()
    var offset = 0
    var filterName: MutableList<String> = ArrayList()

    val toast = CreateToast()
    //val find = FindItem(defValue)
}