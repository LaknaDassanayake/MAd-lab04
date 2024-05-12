package com.example.lab04

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab04.databinding.ViewBinding

class Adapter(private val data: List<CardInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfo: CardInfo) {
            binding.apply {
                title.text = cardInfo.title
                priority.text = cardInfo.priority

                val color = when (cardInfo.priority.toLowerCase()) {
                    "high" -> Color.parseColor("#F05454")
                    "medium" -> Color.parseColor("#EDC988")
                    else -> Color.parseColor("#00917C")
                }
                mylayout.setBackgroundColor(color)

                root.setOnClickListener {
                    val intent = Intent(root.context, UpdateCard::class.java)
                    intent.putExtra("id", adapterPosition)
                    root.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
