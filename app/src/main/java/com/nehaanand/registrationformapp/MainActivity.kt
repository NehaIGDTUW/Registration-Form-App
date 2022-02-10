package com.nehaanand.registrationformapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_register.setOnClickListener {
            onRegisterClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Mr", "Mrs", "Ms", "Dr")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_title.adapter = spinnerAdapter
    }

    private fun onRegisterClicked() {
        val summary = Summary(
            spinner_title.selectedItem as String,
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_email_address.text.toString(),
            edit_text_phone_number.text.toString(),
            edit_text_password.text.toString()
        )
        val registerActivityIntent = Intent(this, SummaryActivity::class.java)
        registerActivityIntent.putExtra("Summary", summary)
        startActivity(registerActivityIntent)
    }
}