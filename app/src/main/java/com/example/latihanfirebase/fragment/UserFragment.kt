package com.example.latihanfirebase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihanfirebase.R
import com.example.latihanfirebase.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth

class UserFragment : Fragment() {

    private var _binding : FragmentUserBinding? = null
    lateinit var auth: FirebaseAuth

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserBinding.inflate(inflater,container, false)
        return binding.root
    }

    


}