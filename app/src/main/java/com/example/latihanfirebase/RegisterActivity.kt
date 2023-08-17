package com.example.latihanfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.latihanfirebase.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth
    lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            val email = binding.edtEmailRegister.text.toString()
            val password = binding.edtPasswordRegister.text.toString()

            // validasi email
            if(email.isEmpty()){
                binding.edtEmailRegister.error = "Email harus diisi"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailRegister.error = "Email Tidak Valid"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }

            // validasi password
            if(password.isEmpty()){
                binding.edtPasswordRegister.error = "Password harus diisi"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }


        }
    }
}