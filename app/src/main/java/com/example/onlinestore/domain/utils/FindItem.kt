package com.example.onlinestore.domain.utils

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import com.example.onlinestore.presentation.MainPageActivity
import com.example.onlinestore.presentation.adapter.EbayItemAdapter
import com.example.onlinestore.data.remote.api.EbayApi
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.domain.models.Item
import com.example.onlinestore.domain.models.DefValue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FindItem(private val defValue: DefValue) {
    fun findItem(
        binding: ActivityMainPageBinding,
        activity: MainPageActivity,
    ) {

        defValue.isLoading = true
        defValue.noMoreItems = false

        val url = "https://api.ebay.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(EbayApi::class.java)

        val filtered = defValue.filterName.joinToString(separator = ",")
        println(filtered)

        //find items
        api.findEbayItem(binding.sv.text.toString(), defValue.offset, filtered).enqueue(object :
            Callback<Item> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Item>, response: Response<Item>) {

                binding.loadMoreBar.visibility = View.GONE
                binding.defBar.visibility = View.GONE

                Log.d("Retrofit", response.body().toString())

                val responseJson = response.body()

                //check to see if response is null
                if (responseJson?.itemSummaries != null) {

                    //If users scroll to bottom and more items are available
                    if (defValue.offset > 0 && responseJson.itemSummaries.last() != defValue.listOfItems.last()) {
                        defValue.listOfItems.addAll((responseJson.itemSummaries))
                        binding.rv.adapter?.notifyDataSetChanged()
                        defValue.isLoading = false
                        return
                    } else if (defValue.offset > 0) {
                        defValue.toast.showToastMessage("No more items", activity)
                        defValue.isLoading = false
                        defValue.noMoreItems = true
                        return
                    }

                    //send data to adapter
                    defValue.listOfItems = responseJson.itemSummaries
                    binding.rv.adapter = EbayItemAdapter(defValue.listOfItems, activity)
                } else {
                    defValue.toast.showToastMessage("Can't find item", activity)
                }

                defValue.isLoading = false
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Log.d("Retrofit", t.toString())
            }
        })
    }
}