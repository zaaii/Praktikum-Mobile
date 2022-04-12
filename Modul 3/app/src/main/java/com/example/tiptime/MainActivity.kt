package com.example.tiptime

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    // Binding object instance with access to the views in the activity_main.xml layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout XML file and return a binding object instance
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the content view of the Activity to be the root view of the layout
        setContentView(binding.root)

        // Setup a click listener on the calculate button to calculate the tip
        binding.calculateButton.setOnClickListener { Konversi() }

        // Set up a key listener on the EditText field to listen for "enter" button presses
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }

    /**
     * Mengkonversi berdasarkan input user.
     */
    private fun Konversi() {
        // Get the decimal value from the cost of service EditText field
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val nilaiUang = stringInTextField.toDoubleOrNull()

        // If the cost is null or 0, then display 0 tip and exit this function early.
        if (nilaiUang == null || nilaiUang == 0.0) {
            displayUang(0.0)
            return
        }

        // Get the tip percentage based on which radio button is selected
        val mataUang = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.opsi_euro -> 14370
            R.id.opsi_usd -> 14371
            R.id.opsi_yen -> 115
            else -> 3831
        }

        // Calculate the tip
        var konversiUang = nilaiUang * mataUang

        // If the switch for rounding up the tip toggled on (isChecked is true), then round up the
        // tip. Otherwise do not change the tip value.

        // Display the formatted tip value onscreen
        displayUang(nilaiUang)
    }

    /**
     * Format the currency according to the local currency and display it onscreen.
     * Example would be "Nilai rupiah : Rp.1.000.000,00".
     */
    private fun displayUang(tip: Double) {
        val indonesianLocale = Locale("id", "ID")
        val formattedTip = NumberFormat.getCurrencyInstance(indonesianLocale).format(tip)
        binding.tipResult.text = "Nilai Rupiah: $formattedTip"
    }

    /**
     * Key listener for hiding the keyboard when the "Enter" button is tapped.
     */
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}
