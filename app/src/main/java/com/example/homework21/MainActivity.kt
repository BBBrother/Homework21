package com.example.homework21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = resources.getStringArray(R.array.Colors)
        val spinner = findViewById<Spinner>(R.id.spinner)
        lateinit var color: String

        if (spinner != null){
            spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    color = colors[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.upperHalfOfScreen, ColorFragment.newInstance(color))
                .addToBackStack("ColorFragment")
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount ==0) {
            super.onBackPressed()
        } else supportFragmentManager.popBackStack()
    }
}