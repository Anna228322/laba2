package com.example.laba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.laba2.databinding.ActivityMainBinding
import com.example.laba2.databinding.RvTarifBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Adapter()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false,
        )

        val list = listOf<Item>(
            Item(
                "Тариф \"Улыбка (бесплатный интернет и телевидение)\"",
                "Скорость до 100 Мбит/сек",
                750
            ),
            Item(
                "Тариф \"Безлимит (бесплатный интернет)\"",
                "Скорость до 100 Мбит/сек",
                450
            ),
            Item(
                "Тариф \"Засмотрись (бесплатный интернет и телевидение с платными подписками)\"",
                "Скорость до 100 Мбит/сек",
                1100
            ),
            Item(
                "Тариф \"А тебе ничего (ничего)\"",
                "Скорости нет",
                100
            )
        )

        adapter.submitList(list)
    }

    class Adapter: ListAdapter<Item, VH>(
    object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
    }
    ) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
            VH(RvTarifBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ))

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.bind(getItem(position))
        }

    }

    data class Item(
        val title: String,
        val subtitle: String,
        val price: Int,
    )

    class VH(private val binding: RvTarifBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.name.text = item.title
            binding.speed.text = item.subtitle
            binding.cost.text = "${item.price} ₽"
        }
    }
}