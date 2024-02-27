package com.example.onlinestore.models

data class Item(
    val href: String,
    val itemSummaries: MutableList<ItemSummary>
)

data class ItemSummary(
    val itemId: String,
    val title: String,
    val image: Image,
    val price: Price,
    val seller: Seller,
    val condition: String,
    val shippingOptions: List<ShippingOptions>?,
    val itemWebUrl: String
)

data class Image(
    val imageUrl: String
)

data class Price(
    val value: String,
    val currency: String
)

data class Seller(
    val username: String,
    val feedbackPercentage: String,
    val feedbackScore: Int
)

data class ShippingOptions(
    val shippingCostType: String,
    val shippingCost: ShippingCost
)

data class ShippingCost(
    val value: String,
    val currency: String
)