package com.example.katarzkubat.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.katarzkubat.coderswag.Model.Product
import com.example.katarzkubat.coderswag.R
import com.example.katarzkubat.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        val resourceId = resources.getIdentifier(product.image, "drawable", packageName)
        detailProductImage.setImageResource(resourceId)
        detailProductTitle.text = product.title
        detailProductPrice.text = product.price

    }
}
