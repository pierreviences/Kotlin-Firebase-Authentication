package com.example.latihanfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.latihanfirebase.databinding.ActivityLoginBinding
import com.example.latihanfirebase.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()

            // validasi email
            if(email.isEmpty()){
                binding.edtEmailLogin.error = "Email harus diisi"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailLogin.error = "Email Tidak Valid"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            // validasi password
            if(password.isEmpty()){
                binding.edtPasswordLogin.error = "Password harus diisi"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }

            // validasi panjang password
            if(password.length < 6){
                binding.edtPasswordLogin.error = "Password minimal 6 karakter"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }

        }
    }
}