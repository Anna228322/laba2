package com.example.laba2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laba2.R
import com.example.laba2.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment, TariffsFragment())
            .commit()
    }
}


