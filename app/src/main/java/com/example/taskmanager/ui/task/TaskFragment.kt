package com.example.taskmanager.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentTaskBinding
import com.example.taskmanager.ui.task.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.toString().isNotEmpty()){
                findNavController().navigateUp()
            }else{
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                binding.etTitle.error = "ERROR"
                return@setOnClickListener
            }
            val data = Task(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.toString()
            )
            setFragmentResult(RESULT_KEY, bundleOf(TASK_KEY to data))
            findNavController().navigateUp()
        }
    }
    companion object{
        const val RESULT_KEY = "result.key"
        const val TASK_KEY = "task.key"
    }
}