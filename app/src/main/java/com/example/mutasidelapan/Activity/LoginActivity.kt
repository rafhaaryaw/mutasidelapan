package com.example.mutasidelapan.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mutasidelapan.DataFragment.InputDataFragment
import com.example.mutasidelapan.ListDataFragment
import com.example.mutasidelapan.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var Auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Auth = FirebaseAuth.getInstance()
        
        supportActionBar?.hide()
    }
}