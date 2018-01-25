package com.example.katarzkubat.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.katarzkubat.coderswag.Model.Product
import com.example.katarzkubat.coderswag.R

/**
 * Created by katarz.kubat on 25.01.2018.
 */
class ProductAdapter(val context: Context, val product: List<Product>, val itemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    override fun getItemCount(): Int {
        return product.count()
    }

    override fun onBindViewHolder(holder: ProductHolder?, position: Int) {
       holder?.bindProduct(product[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
      val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view, itemClick)
    }

    inner class ProductHolder(itemView: View?, itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context) {

            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
            itemView.setOnClickListener{itemClick(product)}
        }

    }
}