package com.example.quoteappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteappretrofit.api.Quoteservice
import com.example.quoteappretrofit.api.Retrofithelper
import com.example.quoteappretrofit.models.Quote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var recyclerview : RecyclerView
    lateinit var adapter:QuotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview = findViewById(R.id.Recyclerview)
        val qouteservices = Retrofithelper.getInstance().create(Quoteservice::class.java)
        val result = qouteservices.getQuote(1)

        result.enqueue(object :Callback<Quote>{
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
                val response = response.body()
                if(response != null){
                    adapter = QuotesAdapter(this@MainActivity,response.results)
                    recyclerview.adapter = adapter
                    recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
                Log.d("Result","Error occur")
            }
        })
    }
}