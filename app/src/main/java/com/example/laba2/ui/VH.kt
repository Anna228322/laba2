package com.example.laba2.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.laba2.databinding.RvTarifBinding

class VH(private val binding: RvTarifBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.name.text = item.title
        binding.speed.text = item.subtitle
        binding.cost.text = "${item.price} ₽"
    }
}