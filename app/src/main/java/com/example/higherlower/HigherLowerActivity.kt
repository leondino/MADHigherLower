package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    //Variables
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    //Updates app to start state
    private fun initViews(){
        //Sets button click listeners
        btnHigher.setOnClickListener { onHigherClick() }
        btnEqual.setOnClickListener { onEqualClick() }
        btnLower.setOnClickListener { onLowerClick() }

        updateUI()
    }

    private fun updateUI(){
        //Update last throw text
        lastThrowText.text = getString(R.string.last_throw_text, lastThrow)

        //Update dice picture
        when (currentThrow){
            1 -> diceImage.setImageResource(R.drawable.dice1)
            2 -> diceImage.setImageResource(R.drawable.dice2)
            3 -> diceImage.setImageResource(R.drawable.dice3)
            4 -> diceImage.setImageResource(R.drawable.dice4)
            5 -> diceImage.setImageResource(R.drawable.dice5)
            6 -> diceImage.setImageResource(R.drawable.dice6)
            else -> print("Error, current throw is invalid")
        }
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick(){
        rollDice()
        if (currentThrow > lastThrow)
            onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onLowerClick(){
        rollDice()
        if (currentThrow < lastThrow)
            onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onEqualClick(){
        rollDice()
        if (currentThrow == lastThrow)
            onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onAnswerCorrect(){
        Toast.makeText(this, R.string.correct, Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect(){
        Toast.makeText(this, R.string.incorrect, Toast.LENGTH_LONG).show()
    }
}
