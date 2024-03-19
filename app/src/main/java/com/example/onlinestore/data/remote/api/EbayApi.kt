package com.example.onlinestore.data.remote.api

import retrofit2.Call
import com.example.onlinestore.domain.models.Item
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EbayApi {
    @Headers(
        "Accept: application/json",
        "Authorization:Bearer v^1.1#i^1#I^3#f^0#r^0#p^1#t^H4sIAAAAAAAAAOVYbWwURRju9eOwQAVFvhrEcxGJlN2b3ftod+WO3PUOerTQj6vYFhHndmfLwt7udmeO9sToWT78ocEfICgYbPhIjH8kEEIkwapJUQMJYkjEGIxRiYBiFPAj4YfuXku5VgJIL7GJ9+cyM++88zzPvO+8swMyztK5m2o2/VHmGFPYkwGZQoeDHQdKnSUV9xYVlpcUgBwDR0/mkUxxd9H5+RgmVUNoQtjQNYxcXUlVw0K2M0ClTE3QIVawoMEkwgIRhXhoSZ3AMUAwTJ3ooq5SrlgkQHkh52WBWAX9EuJkv9fq1a77bNYDFCfzwC8iIIu8ByAvb41jnEIxDROoEWsccF4aeGiWb2Z5geMFH8fwvLeNci1DJlZ0zTJhABXMwhWyc80crLeGCjFGJrGcUMFYaGG8PhSLRJc2z3fn+AoO6BAnkKTw0Fa1LiHXMqim0K2XwVlrIZ4SRYQx5Q72rzDUqRC6DuYu4GelZmVe5MSExCMkAw748yLlQt1MQnJrHHaPItFy1lRAGlFI+naKWmokViORDLSWWi5iEZf915iCqiIryAxQ0XCoNdTQQAUjSFNwLYZ0vaYqGooTuqEpQiOIoM/HsT4a+nlokU4MLNTvbUDmYStV65qk2KJh11KdhJGFGg3Xhs3RxjKq1+rNkExsRDl2HDuoIWizN7V/F1NklWbvK0paQriyzdvvwOBsQkwlkSJo0MPwgaxEAQoahiJRwwezsTgQPl04QK0ixBDc7s7OTqbTw+hmu5sDgHW3LKmLi6tQElKWrZ3r/fbK7SfQSpaKiKyZWBFI2rCwdFmxagHQ2qmglwdelh/QfSis4PDef3TkcHYPzYh8ZYjEi3Il8kJQxVUi4EnkI0OCA0HqtnGgBEzTSWiuQcRQoYho0YqzVBKZiiR4fDLnqZIRLfl5mfbyskwnfJKfZmWEAEKJhMhX/Z8S5U5DPY5EE5G8xHre4ryjY23EaPdXtzSRGEp5U42d3qamjojhb4wqUX9dLe6Kt1VUmEk3Fw3caTbclHy1qljKNFvr50MAO9fzJ0KNjgmSRkQvLuoGatBVRUyPrg32mFIDNEk6jlQrj9pHRDJkGLH8nNV5o/cvj4m7452/GvUf1aebssJ2yI4uVvZ8bDmAhsLYFYgR9aTbznUdWtcPu3tlFvWIeCvWzXVUsbZI9rNVpP4rJ5Oly+C1ImMirKdM67bN1Ns3sGZ9DdKsekZMXVWRuYwdcT4nkykCEyoabYmdhwBX4CgrtmwlC6oq/T6eGxEvMVtKV462IykfR3Hxoru8VruHfuQHC7I/ttvxEeh2vF/ocID5YDY7CzzsLHqiuGh8OVYIYhQoM1hp16xvVxMxa1DagIpZOKng8u7XaqrLo/Xb5q5rTn+28+OC8TlvDD0rwLTBV4bSInZczpMDmHFjpISdMLWM8wIPy7M8x/u4NjDrxmgxO6X4Ae6S6+Sse6Tek4uD4V9Lf/kqNqn8NCgbNHI4SgqKux0F8aNf9/S9uOeIc51/qnBxxcwNi7cuF6Y/XXH53JdXw5su71+/8dFzfReLjCUc2Pukc1Fk5o6WmvC7VyTw81tThBMtzJtjXtjxweEr0rXtn2L/kRPTJ5YdK+1sz6inJ23e8ldl856CeYdqz/zu3At+eujShIuLD/dy250/zD6+Jd37haqf3VEyue/Ugpc2dtT+9uz55btq2w6VHJ3aO3krdzb68thjn59oXd2oHthfMvaxmcfX75sx+b373z52anPwqWe8B5d/eOFUk5w5mZzjeGNbzS6anxi++ueBGe+4933yavg5WX78QOuP3897/cEzr6y4hp3fPL+5t+/g8bIF9LdH50xbX1dRfN/O1oXfXdi4u38v/wZTT6A7/REAAA==",
        "Content-Type: application/json",
        "X-EBAY-C-MARKETPLACE-ID: EBAY_US"
    )
    @GET("buy/browse/v1/item_summary/search")
    fun findEbayItem(
        @Query("q") item: String,
        @Query("offset") offsetNum: Int,
        @Query("filter") filterName: String
    )
            : Call<Item>
}