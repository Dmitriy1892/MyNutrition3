package com.coldfier.mynutrition3.searchfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coldfier.mynutrition3.R
import com.coldfier.mynutrition3.databinding.ItemRecViewBinding
import com.coldfier.mynutrition3.retrofit.Food
import com.coldfier.mynutrition3.retrofit.Hint

class SearchFragmentRVAdapter: RecyclerView.Adapter<SearchFragmentRVAdapter.SearchFoodHolder>() {

    var hints = listOf<Hint>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchFoodHolder {

        return SearchFoodHolder(ItemRecViewBinding.inflate(LayoutInflater.from(parent.context)))
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

    class SearchFoodHolder(private var binding: ItemRecViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.food = food
            binding.executePendingBindings()
        }
    }
}