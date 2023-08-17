package com.example.latihanfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
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

            // validasi panjang password
            if(password.length < 6){
                binding.edtPasswordRegister.error = "Password minimal 6 karakter"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)
        }
    }

    private fun RegisterFirebase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

