package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    //Variables
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initView()
    }

    private fun initView(){
        updateUI()
    }

    private fun updateUI(){
        lastThrowText.text = getString(R.string.last_throw_text, lastThrow)
    }
}
