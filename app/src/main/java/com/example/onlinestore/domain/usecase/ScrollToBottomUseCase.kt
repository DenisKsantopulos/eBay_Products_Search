package com.example.onlinestore.domain.usecase

import android.view.View
import com.example.onlinestore.presentation.mainpage.MainPageActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.domain.models.DefValue
import com.example.onlinestore.domain.utils.FindItem

class ScrollToBottomUseCase(private val defValue: DefValue) {
    private val findItem = FindItem(defValue)
    fun scrollToBottom(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
        dy: Int
    ){
        if (dy > 0) {
            val visibleCount = activity.layoutManager.childCount
            val pastVisible = activity.layoutManager.findFirstCompletelyVisibleItemPosition()
            val total = binding.rv.adapter?.itemCount
            if (!defValue.isLoading && !defValue.noMoreItems) {
                //if at the end of the list
                if ((visibleCount + pastVisible) >= total!!) {
                    defValue.offset += 50
                    binding.loadMoreBar.visibility = View.VISIBLE
                    //findItem()
                    findItem.findItem(binding, activity)
                }
            }
        }
    }
}