package com.example.onlinestore.models

data class Item(
    val href: String,
    //val itemSummaries: MutableList<ItemSummary>
    val itemSummaries: List<ItemSummary>
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

//data class Item(
//    val href: String,
//    val total: Int,
//    val next: String,
//    //val limit: Int,
//    val offset: Int,
//    val itemSummaries: List<ItemSummary>
//)
//
//data class ItemSummary(
//    val itemId: String,
//    val title: String,
//    val leafCategoryIds: List<String>,
//    val categories: List<Category>,
//    val image: Image,
//    val price: Price,
//    val itemHref: String,
//    val seller: Seller,
//    val marketingPrice: MarketingPrice,
//    val condition: String,
//    val conditionId: String,
//    val thumbnailImages: List<Image>,
//    val shippingOptions: List<ShippingOption>,
//    val buyingOptions: List<String>,
//    val itemAffiliateWebUrl: String,
//    val itemWebUrl: String,
//    val itemLocation: ItemLocation,
//    val additionalImages: List<Image>,
//    val adultOnly: Boolean,
//    val legacyItemId: String,
//    val availableCoupons: Boolean,
//    val itemCreationDate: String,
//    val topRatedBuyingExperience: Boolean,
//    val priorityListing: Boolean,
//    val listingMarketplaceId: String
//)
//
//data class Category(
//    val categoryId: String,
//    val categoryName: String
//)
//
//data class Image(
//    val imageUrl: String
//)
//
//data class Price(
//    val value: String,
//    val currency: String
//)
//
//data class Seller(
//    val username: String,
//    val feedbackPercentage: String,
//    val feedbackScore: Int
//)
//
//data class MarketingPrice(
//    val originalPrice: Price,
//    val discountPercentage: String,
//    val discountAmount: Price,
//    val priceTreatment: String
//)
//
//data class ShippingOption(
//    val shippingCostType: String,
//    val shippingCost: Price
//)
//
//data class ItemLocation(
//    val postalCode: String,
//    val country: String
//)
