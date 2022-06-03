package com.example.contactlist

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhoneDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)

        val intentActivity = intent

        if(intentActivity.hasExtra("phoneNumber") && intentActivity.hasExtra("ContactName")){
            val partId: String? = intentActivity.getStringExtra("phoneNumber")
            val name: String? = intentActivity.getStringExtra("ContactName")

            val phoneNumber = findViewById<TextView>(R.id.tv_item_id)
            val contactName = findViewById<TextView>(R.id.tv_item_name)

            phoneNumber.text = partId
            contactName.text = name
        }
    }
}