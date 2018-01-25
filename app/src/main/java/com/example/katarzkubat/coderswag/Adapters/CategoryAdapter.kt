package com.example.katarzkubat.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.katarzkubat.coderswag.Model.Category
import com.example.katarzkubat.coderswag.R

/**
 * Created by katarz.kubat on 23.01.2018.
 */
class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val categoryView: View
        val holder: ViewHolder

        if(convertView == null) {

            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()

            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holder
            println("I exist for first time")

        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("Let's recycle, let's recycle")
        }

        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title

        return categoryView

    }
    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {

        var categoryImage: ImageView? = null
        var categoryName: TextView? = null

    }
}