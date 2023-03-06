package com.example.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.ItemExampleBinding

class NumberAdapter : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    private val data = (1..10).toList()

    inner class ViewHolder(private val binding: ItemExampleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(number: Int) {
            binding.tvNumber.text = number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}