package com.nehaanand.registrationformapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : AppCompatActivity() {
    private lateinit var summary: Summary
    private lateinit var summaryPreviewText: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        displaySummary()
        setUpButton()
    }

    private fun displaySummary() {
        summary = intent.getSerializableExtra("Summary") as Summary
        summaryPreviewText = """
            Hey ${summary.firstName} ${summary.lastName},
            
            You registered to our app and entered the following credentials for the same :
            
            First Name : ${summary.firstName}
            Last Name : ${summary.lastName}
            Email ID : ${summary.emailAddress}
            Password : ${summary.password}
        """.trimIndent()
        text_view_summary.text = summaryPreviewText
    }

    private fun setUpButton() {
        button_message.setOnClickListener {
            //Send message Intent
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data =
                    Uri.parse("smsto: ${summary.phoneNumber}")  // This ensures only SMS apps respond
                putExtra("sms_body", summaryPreviewText)
            }
            startActivity(intent)
        }

        button_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data =
                    Uri.parse("mailto: ${summary.emailAddress}") // only email apps should handle this
                putExtra(Intent.EXTRA_SUBJECT, summaryPreviewText)
            }
            startActivity(intent)
        }
        button_dial_number.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${summary.phoneNumber}")
            startActivity(intent)
        }
    }
}