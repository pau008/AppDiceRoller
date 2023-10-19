package com.pcmdam.appdiceroller;
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var costEditText: EditText
    private lateinit var amazingRadio: RadioButton
    private lateinit var goodRadio: RadioButton
    private lateinit var okayRadio: RadioButton
    private lateinit var roundSwitch: Switch
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        costEditText = findViewById(R.id.costEditText)
        amazingRadio = findViewById(R.id.amazingRadio)
        goodRadio = findViewById(R.id.goodRadio)
        okayRadio = findViewById(R.id.okayRadio)
        roundSwitch = findViewById(R.id.roundSwitch) // Agregado el Switch
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)
        titleTextView = findViewById(R.id.titleTextView)

        costEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                costEditText.text.clear()
            }
        }

        calculateButton.setOnClickListener {
            calculateTotal()
        }
    }

    private fun calculateTotal() {
        val costString = costEditText.text.toString()
        if (costString.isNotBlank()) {
            val cost = costString.toDouble()
            val percentage = when {
                amazingRadio.isChecked -> 0.20
                goodRadio.isChecked -> 0.18
                okayRadio.isChecked -> 0.15
                else -> 0.0
            }

            var total = cost + (cost * percentage)

            if (roundSwitch.isChecked) {
                total = Math.ceil(total).toDouble()
            }

            val formattedTotal = NumberFormat.getCurrencyInstance().format(total)
            resultTextView.text = "Cost total: $formattedTotal"
        } else {
            resultTextView.text = "Introdueix el cost del servei primer."
        }
    }
}

