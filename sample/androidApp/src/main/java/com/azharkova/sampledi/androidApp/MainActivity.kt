package com.azharkova.sampledi.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azharkova.sampledi.shared.Greeting
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.azharkova.sampledi.shared.config.ConfigurationApp

fun greet(): String {
    return Greeting().greeting()
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
