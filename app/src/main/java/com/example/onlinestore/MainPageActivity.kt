package com.example.onlinestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinestore.adapter.EbayItemAdapter
import com.example.onlinestore.api.EbayApi
import com.example.onlinestore.databinding.ActivityMainPageBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding
    private lateinit var adapter: EbayItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EbayItemAdapter()
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit  = Retrofit.Builder()
            .baseUrl("https://api.ebay.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val ebayApi = retrofit.create(EbayApi::class.java)

        binding.sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                CoroutineScope(Dispatchers.IO).launch {

                    val list = query?.let { ebayApi.findEbayItem(it,20,0) }
                    runOnUiThread{
                        binding.apply {
                            adapter.submitList(list?.items)
                        }
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}