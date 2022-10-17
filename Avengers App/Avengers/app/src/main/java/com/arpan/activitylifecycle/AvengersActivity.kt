package com.arpan.activitylifecycle
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var messageEt: EditText
    lateinit var sendBtn: Button
    lateinit var logoutBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.the_avengers)

        titleName = sharedPreferences.getString("Title","The Avengers")
        title = "Welcome, $titleName"

        //message activity coding
        messageEt = findViewById(R.id.etMessage)
        sendBtn = findViewById(R.id.btnSend)
        sendBtn.setOnClickListener {
            val intentA = Intent(this@AvengersActivity, MessageActivity::class.java)
            val messageToDisplay = messageEt.text.toString()
            Toast.makeText(this@AvengersActivity, "Message Sent", Toast.LENGTH_LONG
            ).show()
            intentA.putExtra("Message",messageToDisplay)
            startActivity(intentA)
        }

        //logout activity functionality
        logoutBtn = findViewById(R.id.btnLogout)

        logoutBtn.setOnClickListener {
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }
    }
}