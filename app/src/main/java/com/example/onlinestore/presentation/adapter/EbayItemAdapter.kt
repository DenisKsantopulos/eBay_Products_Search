package com.example.onlinestore.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.databinding.ItemListBinding
import com.example.onlinestore.models.ItemSummary
import com.squareup.picasso.Picasso

class EbayItemAdapter(private val result: List<ItemSummary>, private val context: Context) :
    RecyclerView.Adapter<CustomViewHolder>() {
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

        if (shipping != null) {
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

        if (holder.binding.ibNoFav.isVisible) {

        }
        holder.binding.ibNoFav.setOnClickListener {
            if (holder.binding.ibNoFav.isVisible) {
                holder.binding.ibNoFav.isVisible = false
                holder.binding.ibFav.isVisible = true
            } else {
                holder.binding.ibNoFav.isVisible = true
                holder.binding.ibFav.isVisible = false
            }
        }
        holder.binding.ibFav.setOnClickListener {
            if (holder.binding.ibNoFav.isVisible) {
                holder.binding.ibNoFav.isVisible = false
                holder.binding.ibFav.isVisible = true
            } else {
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

class CustomViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
}

