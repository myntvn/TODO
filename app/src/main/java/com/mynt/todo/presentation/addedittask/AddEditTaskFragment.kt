package com.mynt.todo.presentation.addedittask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mynt.todo.R

class AddEditTaskFragment : Fragment() {

//    private lateinit var binding:

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.addtask_frag, container, false)
    }

}