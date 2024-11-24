package com.example.fuelstation

import MainActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelstation.databinding.ActivityManagerLoginBinding

class ManagerLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManagerLoginBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        // Handle login button click
        binding.MloginButton.setOnClickListener {
            val username = binding.Mloginusername.text.toString()
            val password = binding.Mloginpassword.text.toString()


            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginManager(username, password)
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle redirect to signup activity
        binding.MsignupRedirect.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Method to authenticate manager credentials
    private fun loginManager(username: String, password: String) {
        val managerExists = databaseHelper.readUser(username, password, "manager")  // Check for "manager"
        if (managerExists) {
            Toast.makeText(this, "Manager Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Invalid Manager Credentials", Toast.LENGTH_SHORT).show()
        }
    }

}
