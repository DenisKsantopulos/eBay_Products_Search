package com.example.onlinestore.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.R
import com.example.onlinestore.presentation.account.LogInActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.domain.usecase.ClickFreeShipUseCase
import com.example.onlinestore.domain.usecase.ClickSearchUseCase
import com.example.onlinestore.domain.usecase.ScrollToBottomUseCase
import com.example.onlinestore.models.ItemSummary
import com.example.onlinestore.domain.utils.CreateToast
import com.example.onlinestore.domain.utils.FindItem

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
    private val clickSearch = ClickSearchUseCase()
    private val clickFreeShip = ClickFreeShipUseCase()
    private val scrollToBottom = ScrollToBottomUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val linkToLogIn: ImageButton = findViewById(R.id.imageButton2)
        val linkToLogIn: ImageButton = binding.imageButton2

        linkToLogIn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        layoutManager = LinearLayoutManager(this@MainPageActivity)
        binding.rv.layoutManager = layoutManager

        //click on search
        binding.btnSearch.setOnClickListener {
            clickSearch.clickSearch(binding, this)
        }

        //scroll to bottom(more item)
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                scrollToBottom.scrollToBottom(binding, this@MainPageActivity, dy)
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        binding.sbFree.setOnClickListener {
            //If already selected or not
            clickFreeShip.clickFreeShip(binding,this)
        }
    }
}