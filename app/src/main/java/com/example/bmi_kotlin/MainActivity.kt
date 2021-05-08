package com.example.bmi_kotlin

import android.R.attr.button
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
        val textViewPPM: TextView? = findViewById(R.id.textView3)
        val editTextHeight: EditText? = findViewById(R.id.editTextNumberHeight)
        val editTextWeight: EditText? = findViewById(R.id.editTextNumberWeight)
        val editTextAge: EditText? = findViewById(R.id.editTextNumberAge)
        val buttonHome: Button? = findViewById(R.id.buttonHome)
        val buttonCalories = findViewById<Button>(R.id.buttonCalories)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonBMI = findViewById<Button>(R.id.buttonBMI)
        val button = findViewById<Button>(R.id.button)

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

        buttonCalories.setOnClickListener {
            val height = editTextHeight!!.text.toString().toInt().toDouble()
            val weight = editTextWeight!!.text.toString().toInt().toDouble()
            val age = editTextAge!!.text.toString().toInt().toDouble()
            //radioGroup.equals("Male")
            if (true) {
                val PPM = 66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
                val decimalFormat = DecimalFormat("#.##")
                val PMMFormat = decimalFormat.format(PPM)
                textViewPPM!!.setText(PMMFormat)
                button!!.visibility = View.VISIBLE
            }
            //selectedRbText.equals("Female")
            if (radioGroup.equals("Female")) {
                val PPM = 655.1 + 9.563 * weight + 1.85 * height - 4.676 * age
                val decimalFormat = DecimalFormat("#.##")
                val PMMFormat = decimalFormat.format(PPM)
                textViewPPM!!.setText(PMMFormat)
                button!!.visibility = View.VISIBLE
            }

            findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
                Snackbar.make(view, "Replace with your own action!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
/*
        button.setOnClickListener {
            val url = "http://stackoverflow.com/"
        }

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://stackoverflow.com/";
                val height = Integer.parseInt(editTextHeight.getText().toString());
                val weight = Integer.parseInt(editTextWeight.getText().toString());
                double bmi = (weight/(height*height))*10000;
                if (bmi <= 18){url = "https://blog.nasm.org/recipes-for-gaining-muscle";}
                if (bmi > 18 && bmi < 25){url = "https://www.delicious.com.au/recipes/collections/gallery/60-healthy-dinners-you-can-cook-in-30-minutes/1vo4q819";}
                if (bmi >= 25){url = "https://www.eatingwell.com/recipes/18045/weight-loss-diet/";}
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }

 */
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