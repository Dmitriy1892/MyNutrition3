package com.coldfier.mynutrition3.searchfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.WorkerThread
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.coldfier.mynutrition3.R
import com.coldfier.mynutrition3.retrofit.Food
import com.coldfier.mynutrition3.retrofit.Hint

class SearchFragmentRVAdapter: RecyclerView.Adapter<SearchFragmentRVAdapter.SearchFoodHolder>() {

    var hints = listOf<Hint>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchFoodHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_rec_view, parent, false)
        return SearchFoodHolder(view)
    }

    override fun onBindViewHolder(holder: SearchFoodHolder, position: Int) {
        val item = hints[position].food
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {
        return hints.size
    }

    class SearchFoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(food: Food) {
            val foodName = itemView.findViewById<TextView>(R.id.food_name_text_view)
            val calories = itemView.findViewById<TextView>(R.id.calories_text_view)
            val image = itemView.findViewById<ImageView>(R.id.image_view_container)

            foodName.text = food.label
            calories.text = food.nutrients?.calories.toString()

            Glide.with(image.context)
                .load(food.image)
                .apply(RequestOptions().error(R.mipmap.no_image_icon))
                .into(image)

        }
    }
}