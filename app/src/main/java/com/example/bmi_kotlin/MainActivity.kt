package com.example.bmi_kotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val textViewBMI: TextView? = findViewById(R.id.textView)
        val textViewPPM: EditText? = null
        val editTextHeight: EditText? = findViewById(R.id.editTextNumberHeight)
        val editTextWeight: EditText? = findViewById(R.id.editTextNumberWeight)
        val editTextAge: EditText? = null
        val buttonHome: Button? = null
        val buttonCalories: Button? = findViewById(R.id.buttonCalories)
        val radioGroup: RadioGroup? = null
        val buttonBMI = findViewById<Button>(R.id.buttonBMI)

        buttonBMI.setOnClickListener {
            try {
                val height = editTextHeight!!.text.toString().toInt().toDouble()
                val weight = editTextWeight!!.text.toString().toInt().toDouble()
                val bmi = weight / (height * height) * 10000
                val decimalFormat = DecimalFormat("#.##")
                val bmiFormat = decimalFormat.format(bmi)
                textViewBMI!!.text = bmiFormat
                buttonCalories!!.visibility = View.VISIBLE
            } catch (e: NumberFormatException) {
                val height = 0.0
            }
        }


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}