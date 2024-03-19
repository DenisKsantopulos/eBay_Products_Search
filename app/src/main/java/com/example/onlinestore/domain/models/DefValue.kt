package com.example.onlinestore.domain.models

import com.example.onlinestore.domain.utils.CreateToast

class DefValue {

    var isLoading = false
    var noMoreItems = false
    var listOfItems: MutableList<ItemSummary> = ArrayList()
    var offset = 0
    var filterName: MutableList<String> = ArrayList()

    val toast = CreateToast()
}