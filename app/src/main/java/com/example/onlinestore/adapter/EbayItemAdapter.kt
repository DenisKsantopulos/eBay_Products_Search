package com.example.onlinestore.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.MainPageActivity
import com.example.onlinestore.R
import com.example.onlinestore.databinding.ItemListBinding
import com.example.onlinestore.models.Item
import com.example.onlinestore.models.ItemSummary
import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.ebay_item_row.view.feedbackTextView
//import kotlinx.android.synthetic.main.ebay_item_row.view.imageView
//import kotlinx.android.synthetic.main.ebay_item_row.view.itemNameTextView
//import kotlinx.android.synthetic.main.ebay_item_row.view.priceTextView
//import kotlinx.android.synthetic.main.ebay_item_row.view.sellerTextView
//import kotlinx.android.synthetic.main.ebay_item_row.view.shippingTextView

//import kotlinx.android.synthetic.main.ebay_item_row.view.*

class EbayItemAdapter(private val result: List<ItemSummary>, private val context: Context): RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = result[position]

        val shipping = result[position].shippingOptions

        val fullTitle = item.title
        val words = fullTitle.split(" ")
        val truncatedTitle = words.take(4).joinToString(" ") + "..."
        holder.binding.tvItemName.text = truncatedTitle

        //holder.binding.itemNameTextView.text = item.title

        //price and shipping
        holder.binding.priceTextView.text = item.price.value + item.price.currency

        if(shipping != null) {
            for (shippingIndex in shipping) {
                if (shippingIndex.shippingCost != null && shippingIndex.shippingCost.value == "0.00") {
                    val shippingPrice = "Free Shipping"
                    holder.binding.shippingTextView.text = shippingPrice
                } else if (shippingIndex.shippingCost == null) {
                    holder.binding.shippingTextView.text = ""
                } else {
                    holder.binding.shippingTextView.text =
                        "+ " + shippingIndex.shippingCost.value + shippingIndex.shippingCost.currency
                }
            }
        }
        //seller info
        holder.binding.sellerTextView.text = item.seller.username

//        holder.binding.sellerTextView.text = if (item.seller.username.length > 8) {
//            item.seller.username.substring(0, 10) + "..."
//        } else {
//            item.seller.username
//        }

        //holder.binding.feedbackTextView.text = item.seller.feedbackPercentage + "%"
        holder.binding.tvCondition.text = item.condition


        val iconImage = holder.binding.imageView
        Picasso.get().load(item.image.imageUrl).into(iconImage)

        if (holder.binding.ibNoFav.isVisible){

        }
        holder.binding.ibNoFav.setOnClickListener{
            if (holder.binding.ibNoFav.isVisible){
                holder.binding.ibNoFav.isVisible = false
                holder.binding.ibFav.isVisible = true
            }else{
                holder.binding.ibNoFav.isVisible = true
                holder.binding.ibFav.isVisible = false
            }
        }
        holder.binding.ibFav.setOnClickListener{
            if (holder.binding.ibNoFav.isVisible){
                holder.binding.ibNoFav.isVisible = false
                holder.binding.ibFav.isVisible = true
            }else{
                holder.binding.ibNoFav.isVisible = true
                holder.binding.ibFav.isVisible = false
            }
        }

        holder.itemView.setOnClickListener {
            val url = item.itemWebUrl
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(context, i, null)
        }
    }

}

class CustomViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
{

}
//
//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.onlinestore.R
//import com.example.onlinestore.databinding.ItemListBinding
//import com.example.onlinestore.models.Item
//import com.squareup.picasso.Picasso
//
//class EbayItemAdapter: ListAdapter<Item, EbayItemAdapter.Holder>(Comporator()){
//
//    class Holder(view: View): RecyclerView.ViewHolder(view){
//        private val binding = ItemListBinding.bind(view)
//
//        @SuppressLint("SetTextI18n")
//        fun bind(item: Item) = with(binding){
//            itemNameTextView.text = item.itemSummaries.firstOrNull()?.title ?: "No title"
//            priceTextView.text = item.itemSummaries.firstOrNull()?.price?.toString() ?: "No price"
//
//            val iconImage = binding.imageView
//            Picasso.get().load(item.itemSummaries.firstOrNull()?.image?.imageUrl).into(iconImage)
//            binding.feedbackTextView.text = item.itemSummaries.firstOrNull()?.seller?.username
//
//            binding.priceTextView.text = item.itemSummaries.firstOrNull()?.price?.value + item.itemSummaries.firstOrNull()?.price?.currency
//        }
//
////        fun bind(item: Item) {
////            binding.itemNameTextView.text = item.title
////            binding.itemNameTextView.text = item.description
////            //binding.priceTextView.text = item.price.value // + item.price.currency
////
//////            val iconImage = binding.imageView
//////            Picasso.get().load(item.image.imageUrl).into(iconImage)
////
////            //binding.sellerTextView.text = item.seller.username
////           // binding.feedbackTextView.text = item.seller.feedbackPercentage // + "%"
////        }
//
//
//    }
//
//
//    class Comporator: DiffUtil.ItemCallback<Item>(){
//
//        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
//            return oldItem.itemSummaries.first().itemId == newItem.itemSummaries.first().itemId
//              //return oldItem.itemSummaries. == newItem.itemSummaries.itemId
//        }
//
//        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
//        return Holder(view)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.bind(getItem(position))
//    }
//}
