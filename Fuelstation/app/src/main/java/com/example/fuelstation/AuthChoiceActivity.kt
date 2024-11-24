package com.example.fuelstation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelstation.databinding.ActivityAuthChoiceBinding

class AuthChoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthChoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Redirect to Manager Login & Signup
        binding.btnManagerAuth.setOnClickListener {
            val intent = Intent(this, ManagerLoginActivity::class.java)  // Redirect to Manager login/signup pages
            startActivity(intent)
        }

        // Redirect to Owner Login & Signup
        binding.btnOwnerAuth.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)  // Redirect to Owner login/signup pages
            startActivity(intent)
        }
    }
}
