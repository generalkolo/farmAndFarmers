package com.example.cleanWithCoRoutine.statistics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails
import com.example.cleanWithCoRoutine.statistics.databinding.FarmListItemBinding

class FarmAndFarmDetailsAdapter(
    private val data: List<FarmAndFarmersDetails>,
    val clickListener: FarmClickedListener
) :
    RecyclerView.Adapter<FarmAndFarmDetailsAdapter.ViewHolder>() {

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener.onClick(item)
        }
    }

    class ViewHolder private constructor(val binding: FarmListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FarmAndFarmersDetails) {
            binding.farmItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FarmListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class FarmClickedListener(val clickListener: (clickedItem: FarmAndFarmersDetails) -> Unit) {
    fun onClick(itemClicked: FarmAndFarmersDetails) = clickListener(itemClicked)
}