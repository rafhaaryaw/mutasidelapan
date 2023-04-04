package com.example.mutasidelapan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class homeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

    //supportActionBar?.hide()

    }
}