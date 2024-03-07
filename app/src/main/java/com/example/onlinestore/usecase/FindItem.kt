package com.example.onlinestore.usecase

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import com.example.onlinestore.MainPageActivity
import com.example.onlinestore.adapter.EbayItemAdapter
import com.example.onlinestore.api.EbayApi
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.models.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FindItem {
    fun findItem(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
    ) {

        activity.isLoading = true
        activity.noMoreItems = false

        val url = "https://api.ebay.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(EbayApi::class.java)

        val filtered = activity.filterName.joinToString(separator = ",")
        println(filtered)

        //find items
        api.findEbayItem(binding.sv.text.toString(), activity.offset, filtered).enqueue(object:
            Callback<Item> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Item>, response: Response<Item>) {

                binding.loadMoreBar.visibility = View.GONE
                binding.defBar.visibility = View.GONE

                Log.d("Retrofit", response.body().toString())

                val responseJson = response.body()

                //check to see if response is null
                if(responseJson?.itemSummaries != null) {

                    //If users scroll to bottom and more items are available
                    if(activity.offset > 0 && responseJson.itemSummaries.last() != activity.listOfItems.last()){
                        activity.listOfItems.addAll((responseJson.itemSummaries))
                        binding.rv.adapter?.notifyDataSetChanged()
                        activity.isLoading = false
                        return
                    } else if(activity.offset > 0){
                        activity.toast.showToastMessage("No more items", activity)
                        activity.isLoading = false
                        activity.noMoreItems = true
                        return
                    }

                    //send data to adapter
                    activity.listOfItems = responseJson.itemSummaries
                    binding.rv.adapter = EbayItemAdapter(activity.listOfItems, activity)
                }else {
                    activity.toast.showToastMessage("Can't find item", activity)
                }

                activity.isLoading = false

            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Log.d("Retrofit", t.toString())
            }
        })
    }

}