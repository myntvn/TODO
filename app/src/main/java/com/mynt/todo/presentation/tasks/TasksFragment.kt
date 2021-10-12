package com.mynt.todo.presentation.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mynt.todo.R
import com.mynt.todo.databinding.TasksFragBinding

class TasksFragment : Fragment() {

    private lateinit var binding: TasksFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TasksFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFab()
    }

    private fun setupFab() {
        binding.addTaskFab.setOnClickListener {
            navigateToAddNewTask()
        }
    }

    private fun navigateToAddNewTask() {
        val action = TasksFragmentDirections.actionTasksFragmentToAddEditTaskFragment(
            resources.getString(R.string.add_task)
        )
        findNavController().navigate(action)
    }

}