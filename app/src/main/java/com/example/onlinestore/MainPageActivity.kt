package com.example.onlinestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.account.LogInActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.models.ItemSummary
import com.example.onlinestore.usecase.CreateToast
import com.example.onlinestore.usecase.FindItem

class MainPageActivity : AppCompatActivity() {

    var isLoading = false
    var noMoreItems = false
    var listOfItems: MutableList<ItemSummary> = ArrayList()
    var offset = 0
    var filterName: MutableList<String> = ArrayList()

    lateinit var layoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMainPageBinding

    val toast = CreateToast()

    val find = FindItem()

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

        //click on search
        binding.btnSearch.setOnClickListener {
            if(binding.sv.text.toString() != "") {
                filterName = ArrayList()
                offset = 0
                noMoreItems = false
                binding.defBar.visibility = View.VISIBLE
                //findItem()
                find.findItem(binding,this)
            } else {
                //createToast("Please enter an item.")
                toast.showToastMessage("Please enter an item", this)
            }
        }

        //scroll to bottom(more item)
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
                            //findItem()
                            find.findItem(binding,this@MainPageActivity)
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })


        //free shipping button
        binding.sbFree.setOnClickListener {
            //If already selected or not
            if(binding.sbFree.isSelected){
                binding.sbFree.isSelected = false
                offset = 0
                noMoreItems = false
                filterName.remove("maxDeliveryCost:0")
                binding.defBar.visibility = View.VISIBLE
                //findItem()
                find.findItem(binding,this)

            } else {
                binding.sbFree.isSelected = true
                filterName.add("maxDeliveryCost:0")
                offset = 0
                noMoreItems = false
                binding.defBar.visibility = View.VISIBLE
                //findItem()
                find.findItem(binding,this)
            }
        }
    }
}