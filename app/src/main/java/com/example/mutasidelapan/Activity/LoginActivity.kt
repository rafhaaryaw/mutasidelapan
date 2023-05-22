package com.example.mutasidelapan.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mutasidelapan.DataFragment.InputDataFragment
import com.example.mutasidelapan.ListDataFragment
import com.example.mutasidelapan.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val email = binding.emailInput.text.toString()

        binding.btnLogin.setOnClickListener {
            if (email == "admin@admin.com") {
                val intent = Intent(this, InputDataFragment::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, ListDataFragment::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}