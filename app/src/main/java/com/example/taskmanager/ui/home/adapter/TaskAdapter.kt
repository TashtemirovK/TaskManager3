package com.example.taskmanager.ui.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.databinding.ItemTaskBinding
import com.example.taskmanager.ui.task.model.Task

class TaskAdapter : Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {

        fun bind(task: Task) {

            if (adapterPosition % 2 == 0) {
                binding.tvTitle.setTextColor(Color.WHITE)
                binding.tvDesc.setTextColor(Color.BLACK)
                itemView.setBackgroundColor(Color.BLACK)
            }
            binding.tvTitle.text.toString()
            binding.tvDesc.text.toString()
        }
    }

    fun setData(data: Task) {
        list.add(0, data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list.get(position))
    }
}