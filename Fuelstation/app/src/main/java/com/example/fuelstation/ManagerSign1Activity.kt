package com.example.fuelstation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelstation.databinding.ActivityManagerSign1Binding

class ManagerSign1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityManagerSign1Binding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerSign1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.MsingButton.setOnClickListener {
            val signupUsername = binding.Msingusername.text.toString().trim()
            val signupPassword = binding.Msinguppassword.text.toString().trim()
            if (signupUsername.isNotEmpty() && signupPassword.isNotEmpty()) {
                MsignupDatabase(signupUsername, signupPassword)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.MloginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // In ManagerSign1Activity (for Manager)
    private fun MsignupDatabase(username: String, password: String) {
        val insertRowId = databaseHelper.insertUser(username, password, "manager")  // Assign "manager" role
        if (insertRowId != -1L) {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ManagerLoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }

}
