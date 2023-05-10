package com.example.mutasidelapan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mutasidelapan.Activity.homeActivity

class splashscreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val textmutasi = findViewById<TextView>(R.id.textmutasi)
        val text8 = findViewById<TextView>(R.id.text8)

        textmutasi.alpha = 0f
        text8.alpha = 0f

        textmutasi.animate().setDuration(3000).alpha(1f)
        text8.animate().setStartDelay(500).setDuration(3000).alpha(1f).withEndAction {
            val moveToHome = Intent(this, homeActivity::class.java)
            startActivity(moveToHome)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        supportActionBar?.hide()

    }

}