package com.example.mutasidelapan.DataFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.example.mutasidelapan.R
import com.example.mutasidelapan.databinding.ActivityLoginBinding
import com.example.mutasidelapan.databinding.FragmentInputDataBinding

class InputDataFragment : Fragment() {

    private lateinit var binding: FragmentInputDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInputDataBinding.inflate(inflater, container, false)
        return binding.root
    }
}