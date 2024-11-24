package com.example.fuelstation

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelstation.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var databaseHelper: DatabaseHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        binding.singupButton.setOnClickListener {
            val signupUsername = binding.singupusername.text.toString()
            val signupPassword = binding.singuppassword.text.toString()
            signupDatabase(signupUsername, signupPassword)

        }

        binding.loginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    // In SignupActivity (for Owner)
    private fun signupDatabase(username: String, password: String) {
        val insertRowId = databaseHelper.insertUser(username, password, "owner")  // Assign "owner" role
        if (insertRowId != -1L) {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }

}