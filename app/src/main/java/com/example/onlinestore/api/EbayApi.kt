package com.example.onlinestore.api

import android.telecom.Call
import com.example.onlinestore.models.Item
import com.example.onlinestore.models.Items
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EbayApi {
    @Headers(
        "Accept: application/json",
        "Authorization:Bearer <your token>",
        "Content-Type: application/json",
        "X-EBAY-C-MARKETPLACE-ID: EBAY_US"
    )
    @GET("buy/browse/v1/item_summary/search")
    suspend fun findEbayItem(@Query("q") item: String,
                             @Query("limit") limit: Int,
                             @Query("offset") offsetNum: Int,)
                      //@Query("filter") filterName: String)
    : Items



}