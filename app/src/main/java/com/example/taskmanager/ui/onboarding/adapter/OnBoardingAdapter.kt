package com.example.taskmanager.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.databinding.FragmentOnBoardingBinding
import com.example.taskmanager.databinding.ItemOnboardingBinding
import com.example.taskmanager.model.OnBoarding
import com.example.taskmanager.utils.loadImage

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoarding("https://cdn-icons-png.flaticon.com/512/4345/4345573.png", "Title 1", "Desc 1"),
        OnBoarding("https://pluspng.com/img-png/task-png-big-image-png-2400.png", "Title 2", "Desc 2"),
        OnBoarding("https://pluspng.com/img-png/task-png-png-file-for-linux-720.png", "Title 3", "Desc 3"),
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoarding: OnBoarding) {

            binding.ivOnboard.loadImage(onBoarding.image)
            binding.btnStarted.setOnClickListener {
                onClick()
            }
            binding.btnStarted.isVisible = adapterPosition == data.lastIndex

            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
        }
    }
}