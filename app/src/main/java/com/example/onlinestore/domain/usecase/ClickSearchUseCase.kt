package com.example.onlinestore.domain.usecase

import android.view.View
import com.example.onlinestore.presentation.mainpage.MainPageActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.domain.models.DefValue
import com.example.onlinestore.domain.utils.FindItem

class ClickSearchUseCase(private val defValue: DefValue) {
    private val findItem = FindItem(defValue)
    fun clickSearch(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
    ){
        if (binding.sv.text.toString() != "") {
            defValue.filterName = ArrayList()
            defValue.offset = 0
            defValue.noMoreItems = false
            binding.defBar.visibility = View.VISIBLE
            //findItem()
            findItem.findItem(binding, activity)
        } else {
            //createToast("Please enter an item.")
            defValue.toast.showToastMessage("Please enter an item", activity)
        }
    }
}