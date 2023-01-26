package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate

import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initlistener()
        initTheme()

    }

    private fun initTheme() {
        binding.btgTheme.addOnButtonCheckedListener(object :MaterialButtonToggleGroup.OnButtonCheckedListener{
            override fun onButtonChecked(
                group: MaterialButtonToggleGroup?,
                selectedButtonId: Int,
                isChecked: Boolean
            ) {
                if(isChecked){
                    val btnSelected= when(selectedButtonId){
                        binding.btnDefault.id->AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                        binding.btnDark.id->AppCompatDelegate.MODE_NIGHT_YES
                        else ->AppCompatDelegate.MODE_NIGHT_NO
                    }
                    Log.d("Tag","isChecked:${isChecked} buttonclicked is:${btnSelected}")
                    //  AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -- default mode
                    // AppCompatDelegate.MODE_NIGHT_YES--Dark  mode
                    // AppCompatDelegate.MODE_NIGHT_NO --Light mode
                    AppCompatDelegate.setDefaultNightMode(btnSelected)
                }}

        })
    }

    private fun initlistener() {
       binding.nextPage.setOnClickListener {
           var intent:Intent=Intent(this,ImageViewActivity::class.java)
           startActivity(intent)
       }
    }
}