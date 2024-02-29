package com.example.onlinestore.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
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

        fun bind(item: Item) {
            binding.itemNameTextView.text = item.title
            binding.priceTextView.text = item.price.value + item.price.currency

            val iconImage = binding.imageView
            Picasso.get().load(item.image.imageUrl).into(iconImage)

            binding.sellerTextView.text = item.seller.username
            binding.feedbackTextView.text = item.seller.feedbackPercentage + "%"
        }

    }


    class Comporator: DiffUtil.ItemCallback<Item>(){

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.itemId == newItem.itemId
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
