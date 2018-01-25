package com.example.katarzkubat.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.GridLayout
import com.example.katarzkubat.coderswag.Adapters.ProductAdapter
import com.example.katarzkubat.coderswag.R
import com.example.katarzkubat.coderswag.Services.DataService
import com.example.katarzkubat.coderswag.Utilities.EXTRA_CATEGORY
import com.example.katarzkubat.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductAdapter(this, DataService.getProducts(categoryType)) { product ->
            val detailProductIntent = Intent(this, ProductDetailActivity::class.java)
            detailProductIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(detailProductIntent)
        }

        var spanCount = 2
        val orientation = resources.configuration.orientation

        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        var screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, 2)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}




