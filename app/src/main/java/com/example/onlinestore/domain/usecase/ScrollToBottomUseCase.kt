package com.example.onlinestore.domain.usecase

import android.view.View
import com.example.onlinestore.presentation.MainPageActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding

class ScrollToBottomUseCase {
    fun scrollToBottom(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
        dy: Int
    ){
        if (dy > 0) {
            val visibleCount = activity.layoutManager.childCount
            val pastVisible = activity.layoutManager.findFirstCompletelyVisibleItemPosition()
            val total = binding.rv.adapter?.itemCount
            if (!activity.isLoading && !activity.noMoreItems) {
                //if at the end of the list
                if ((visibleCount + pastVisible) >= total!!) {
                    activity.offset += 50
                    binding.loadMoreBar.visibility = View.VISIBLE
                    //findItem()
                    activity.find.findItem(binding, activity)
                }
            }
        }
    }
}