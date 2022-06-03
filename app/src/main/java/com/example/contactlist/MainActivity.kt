package com.example.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactAdapter(testData,{phoneItem : PhoneData -> phoneItemList(phoneItem)})
    }

    private fun phoneItemList(phoneItem: PhoneData) {
        val detailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        detailActivityIntent.putExtra("phoneNumber", phoneItem.phone.toString())
        detailActivityIntent.putExtra("ContactName", phoneItem.contactName)
        startActivity(detailActivityIntent)
    }

    private fun createPhoneData() : List<PhoneData>{
        val list = ArrayList<PhoneData>()
        list.add(PhoneData(9864934,"Alpha"))
        list.add(PhoneData(1341933,"Bravo"))
        list.add(PhoneData(1401524,"Charlie"))
        return list
    }
}