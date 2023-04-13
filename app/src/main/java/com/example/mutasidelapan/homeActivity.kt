package com.example.mutasidelapan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.example.mutasidelapan.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class homeActivity : AppCompatActivity() {

    private lateinit var image: ImageView

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val card1: CardView = findViewById(R.id.card_profile_diri)

        card1.setOnClickListener {
            image = findViewById(R.id.iv_profile_diri)
            uploadimage(image)
        }

        supportActionBar?.hide()

    }

    private fun uploadimage(image: ImageView?) {
        val intent = Intent()

        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent, 1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            image.setImageURI(data?.data)
        }
    }
}