package com.example.onlinestore

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.account.LogInActivity
import com.example.onlinestore.adapter.EbayItemAdapter
import com.example.onlinestore.api.EbayApi
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.models.Item
import com.example.onlinestore.models.ItemSummary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPageActivity : AppCompatActivity() {

    var isLoading = false
    var noMoreItems = false
    var listOfItems: MutableList<ItemSummary> = ArrayList()
    var offset = 0
    var filterName: MutableList<String> = ArrayList()

    lateinit var layoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMainPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linkToLogIn: ImageButton = findViewById(R.id.imageButton2)

        linkToLogIn.setOnClickListener{
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
        //val itemRecycleView = findViewById<RecyclerView>(R.id.itemRecycleView)

        layoutManager = LinearLayoutManager(this@MainPageActivity)
        binding.rv.layoutManager = layoutManager


        //When user click on search
        binding.btnSearch.setOnClickListener {
            if(binding.sv.text.toString() != "") {
                filterName = ArrayList()
                offset = 0
                noMoreItems = false
                binding.defBar.visibility = View.VISIBLE
                findItem()
            } else {
                createToast("Please enter an item.")
            }
        }

        //If user scroll to bottom, fetch more item
        binding.rv.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if(dy > 0) {
                    val visibleCount = layoutManager.childCount
                    val pastVisible = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = binding.rv.adapter?.itemCount
                    if (!isLoading && !noMoreItems) {
                        //if at the end of the list
                        if ((visibleCount + pastVisible) >= total!!) {
                            offset += 50
                            binding.loadMoreBar.visibility = View.VISIBLE
                            findItem()
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })


        //When user clicks free shipping button
        binding.sbFree.setOnClickListener {
            //If already selected or not
            if(binding.sbFree.isSelected){
                binding.sbFree.isSelected = false
                offset = 0
                noMoreItems = false
                filterName.remove("maxDeliveryCost:0")
                binding.defBar.visibility = View.VISIBLE
                findItem()

            } else {
                binding.sbFree.isSelected = true
                filterName.add("maxDeliveryCost:0")
                offset = 0
                noMoreItems = false
                binding.defBar.visibility = View.VISIBLE
                findItem()
            }
        }

        //When user clicks accept returns buttons
//        binding.acceptReturnsButton.setOnClickListener {
//            //If already selected or not
//            if(binding.acceptReturnsButton.isSelected){
//                binding.acceptReturnsButton.setBackgroundColor(Color.parseColor("#1A6FB1"))
//                binding.acceptReturnsButton.isSelected = false
//                offset = 0
//                noMoreItems = false
//                filterName.remove("returnsAccepted:true")
//                binding.spinningIndicator.visibility = View.VISIBLE
//                fetchJSON()
//
//            } else {
//                binding.acceptReturnsButton.setBackgroundColor(Color.RED)
//                binding.acceptReturnsButton.isSelected = true
//                filterName.add("returnsAccepted:true")
//                offset = 0
//                noMoreItems = false
//                binding.spinningIndicator.visibility = View.VISIBLE
//                fetchJSON()
//            }
//        }
//
//        //When user clicks accept returns buttons
//        binding.itemInCanadaButton.setOnClickListener {
//            //If already selected or not
//            if(binding.itemInCanadaButton.isSelected){
//                binding.itemInCanadaButton.setBackgroundColor(Color.parseColor("#1A6FB1"))
//                binding.itemInCanadaButton.isSelected = false
//                offset = 0
//                noMoreItems = false
//                filterName.remove("itemLocationCountry:CA")
//                binding.spinningIndicator.visibility = View.VISIBLE
//                fetchJSON()
//
//            } else {
//                binding.itemInCanadaButton.setBackgroundColor(Color.RED)
//                binding.itemInCanadaButton.isSelected = true
//                filterName.add("itemLocationCountry:CA")
//                offset = 0
//                noMoreItems = false
//                binding.spinningIndicator.visibility = View.VISIBLE
//                fetchJSON()
//            }
//        }



    }


    //Find ebay item
    fun findItem(){

        isLoading = true

        val url = "https://api.ebay.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(EbayApi::class.java)


        var filtered = filterName.joinToString(separator = ",")
        println(filtered)

        //fetch items
        api.findEbayItem(binding.sv.text.toString(), offset, filtered).enqueue(object:
            Callback<Item> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Item>, response: Response<Item>) {

                binding.loadMoreBar.visibility = View.GONE
                binding.defBar.visibility = View.GONE

                Log.d("Retorfit", response.body().toString())

                val responseJson = response.body()

                //check to see if response is null
                if(responseJson?.itemSummaries != null) {

                    //If users scroll to bottom and more items are available
                    if(offset > 0 && responseJson.itemSummaries.last() != listOfItems.last()){
                        listOfItems.addAll((responseJson.itemSummaries))
                        binding.rv.adapter?.notifyDataSetChanged()
                        isLoading = false
                        return
                    } else if(offset > 0){
                        createToast("No more items")
                        isLoading = false
                        noMoreItems = true
                        return
                    }

                    //send data to adapter
                    listOfItems = responseJson.itemSummaries
                    binding.rv.adapter = EbayItemAdapter(listOfItems, this@MainPageActivity)
                }else {
                    createToast("Can't find item")
                }

                isLoading = false

            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Log.d("Retorfit", t.toString())
            }

        })


    }

    //Display data and send response to adapter
    private fun createToast(message: String) {
        //Create Toast
        val toast = Toast.makeText(
            this@MainPageActivity,
            message,
            Toast.LENGTH_SHORT
        )
        //Change Toast background
        val view = toast.view
        view?.background?.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN)

        toast.show()

    }
}