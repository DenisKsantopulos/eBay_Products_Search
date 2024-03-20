package com.example.onlinestore.domain.usecase

import android.view.View
import com.example.onlinestore.presentation.mainpage.MainPageActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.domain.models.DefValue
import com.example.onlinestore.domain.utils.FindItem

class ClickFreeShipUseCase(private val defValue: DefValue) {
    private val findItem = FindItem(defValue)

    fun clickFreeShip(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
    ){
        //If already selected or not
        if (binding.sbFree.isSelected) {
            binding.sbFree.isSelected = false
            defValue.offset = 0
            defValue.noMoreItems = false
            defValue.filterName.remove("maxDeliveryCost:0")
            binding.defBar.visibility = View.VISIBLE
            //findItem()
            findItem.findItem(binding, activity)
        } else {
            binding.sbFree.isSelected = true
            defValue.filterName.add("maxDeliveryCost:0")
            defValue.offset = 0
            defValue.noMoreItems = false
            binding.defBar.visibility = View.VISIBLE
            //findItem()
            findItem.findItem(binding, activity)
        }
    }
}