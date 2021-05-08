package com.example.bmi_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bmi_kotlin.MainActivity
import com.example.bmi_kotlin.R

class HomeScreen : AppCompatActivity() {
    private var buttonStart: Button? = null
    private var buttonNews: Button? = null
    private var buttonQuiz: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        buttonStart = findViewById<View>(R.id.buttonStart) as Button
        buttonStart!!.setOnClickListener { openMainActivity() }
        //buttonNews = findViewById<View>(R.id.buttonNews) as Button
        //buttonNews!!.setOnClickListener { openNewsScreen() }
        //buttonQuiz = findViewById<View>(R.id.buttonQuiz) as Button
        //buttonQuiz!!.setOnClickListener { openQuizMain() }
    }

    fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
/*
    fun openNewsScreen() {
        val intent = Intent(this, ChartsScreen::class.java)
        startActivity(Intent)
    }

    fun openQuizMain() {
        val intent = Intent(this, QuizMain::class.java)
        startActivity(intent)
    }
 */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}