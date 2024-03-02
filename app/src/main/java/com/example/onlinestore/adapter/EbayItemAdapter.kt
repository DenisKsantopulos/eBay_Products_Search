package com.example.onlinestore.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.databinding.ItemListBinding
import com.example.onlinestore.models.Item
import com.squareup.picasso.Picasso

class EbayItemAdapter: ListAdapter<Item, EbayItemAdapter.Holder>(Comporator()){

    class Holder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemListBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) = with(binding){
            itemNameTextView.text = item.itemSummaries.firstOrNull()?.title ?: "No title"
            priceTextView.text = item.itemSummaries.firstOrNull()?.price?.toString() ?: "No price"

            val iconImage = binding.imageView
            Picasso.get().load(item.itemSummaries.firstOrNull()?.image?.imageUrl).into(iconImage)
            binding.feedbackTextView.text = item.itemSummaries.firstOrNull()?.seller?.username

            binding.priceTextView.text = item.itemSummaries.firstOrNull()?.price?.value + item.itemSummaries.firstOrNull()?.price?.currency
        }

//        fun bind(item: Item) {
//            binding.itemNameTextView.text = item.title
//            binding.itemNameTextView.text = item.description
//            //binding.priceTextView.text = item.price.value // + item.price.currency
//
////            val iconImage = binding.imageView
////            Picasso.get().load(item.image.imageUrl).into(iconImage)
//
//            //binding.sellerTextView.text = item.seller.username
//           // binding.feedbackTextView.text = item.seller.feedbackPercentage // + "%"
//        }


    }


    class Comporator: DiffUtil.ItemCallback<Item>(){

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.itemSummaries.first().itemId == newItem.itemSummaries.first().itemId
              //return oldItem.itemSummaries. == newItem.itemSummaries.itemId
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}
