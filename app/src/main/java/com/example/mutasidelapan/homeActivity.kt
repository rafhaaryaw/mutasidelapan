package com.example.mutasidelapan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.example.mutasidelapan.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class homeActivity : AppCompatActivity() {



    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    supportActionBar?.hide()

    }
}