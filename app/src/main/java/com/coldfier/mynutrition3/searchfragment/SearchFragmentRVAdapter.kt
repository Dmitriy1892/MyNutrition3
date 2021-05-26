package com.coldfier.mynutrition3.searchfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coldfier.mynutrition3.databinding.ItemRecViewBinding
import com.coldfier.mynutrition3.cacheroom.Food

class SearchFragmentRVAdapter: RecyclerView.Adapter<SearchFragmentRVAdapter.SearchFoodHolder>() {

    var foodList = listOf<Food>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchFoodHolder {

        return SearchFoodHolder(ItemRecViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SearchFoodHolder, position: Int) {
        val item = foodList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class SearchFoodHolder(private var binding: ItemRecViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.food = food
            binding.executePendingBindings()
        }
    }
}