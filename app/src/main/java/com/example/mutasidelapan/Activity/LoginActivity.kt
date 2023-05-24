package com.example.mutasidelapan.Activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.mutasidelapan.DataFragment.InputDataFragment
import com.example.mutasidelapan.R
import com.example.mutasidelapan.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        supportActionBar?.hide()

        val btnLoginActivity: Button = findViewById(R.id.btn_login)


        binding.btnLogin.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            //Validasi Email tidak sesuai
            if (email.isEmpty()) {
                binding.emailInput.error = "Email Harus Diisi"
                binding.passwordInput.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailInput.error = "Email Tidak Valid"
                binding.passwordInput.requestFocus()
                return@setOnClickListener
            }

            //Validasi Password
            if (password.isEmpty()) {
                binding.emailInput.error = "Password Harus Diisi"
                binding.passwordInput.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email, password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}