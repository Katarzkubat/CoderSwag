package com.example.katarzkubat.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.katarzkubat.coderswag.Model.Category
import com.example.katarzkubat.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

/**
 * Created by katarz.kubat on 24.01.2018.
 */
class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>,
                              val itemClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {

        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item, parent, false)

        return Holder(view, itemClick)
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {

        holder?.bindCategory(categories[position], context)

    }

    override fun getItemCount(): Int {
       return categories.count()
    }

    inner class Holder(itemView: View?, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {

        //reference to elements
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        //bind data

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
            itemView.setOnClickListener{itemClick(category)}
        }

    }
}