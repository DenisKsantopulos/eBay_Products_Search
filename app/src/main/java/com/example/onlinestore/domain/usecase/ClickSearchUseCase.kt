package com.example.onlinestore.domain.usecase

import android.view.View
import com.example.onlinestore.presentation.MainPageActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding

class ClickSearchUseCase {
    fun clickSearch(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
    ){
        if (binding.sv.text.toString() != "") {
            activity.filterName = ArrayList()
            activity.offset = 0
            activity.noMoreItems = false
            binding.defBar.visibility = View.VISIBLE
            //findItem()
            activity.find.findItem(binding, activity)
        } else {
            //createToast("Please enter an item.")
            activity.toast.showToastMessage("Please enter an item", activity)
        }
    }
}