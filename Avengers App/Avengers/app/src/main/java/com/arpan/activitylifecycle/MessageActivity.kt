package com.arpan.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    var message: String? = "No message received"
    lateinit var messageDisplay: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        title = "Message Page"

        messageDisplay = findViewById(R.id.txtMessageDisplay)

        if(intent != null){
            message = intent.getStringExtra("Message")
            messageDisplay.text = message
        }
    }
}