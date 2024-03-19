package com.example.onlinestore.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.presentation.account.LogInActivity
import com.example.onlinestore.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMainPageBinding

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linkToLogIn: ImageButton = binding.imageButton2

        vm = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)

        linkToLogIn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        layoutManager = LinearLayoutManager(this@MainPageActivity)
        binding.rv.layoutManager = layoutManager

        vm.items.observe(this, Observer { items ->
            vm.updateViewState(items)
        })

        //click on search
        binding.btnSearch.setOnClickListener {
            vm.click(binding, this)
        }

        //scroll to bottom(more item)
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                vm.scroll(binding, this@MainPageActivity, dy)
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        binding.sbFree.setOnClickListener {
            //If already selected or not
            vm.clickFreeShip(binding, this)
        }
    }
}