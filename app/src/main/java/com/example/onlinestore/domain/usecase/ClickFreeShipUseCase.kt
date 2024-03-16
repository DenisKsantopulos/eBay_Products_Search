package com.example.onlinestore.domain.usecase

import android.view.View
import com.example.onlinestore.presentation.MainPageActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding

class ClickFreeShipUseCase {
    fun clickFreeShip(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
    ){
        //If already selected or not
        if (binding.sbFree.isSelected) {
            binding.sbFree.isSelected = false
            activity.offset = 0
            activity.noMoreItems = false
            activity.filterName.remove("maxDeliveryCost:0")
            binding.defBar.visibility = View.VISIBLE
            //findItem()
            activity.find.findItem(binding, activity)
        } else {
            binding.sbFree.isSelected = true
            activity.filterName.add("maxDeliveryCost:0")
            activity.offset = 0
            activity.noMoreItems = false
            binding.defBar.visibility = View.VISIBLE
            //findItem()
            activity.find.findItem(binding, activity)
        }
    }
}