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
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ContactAdapter(testData) { phoneItem: PhoneData ->
            phoneItemList(
                phoneItem
            )
        }
    }

    private fun phoneItemList(phoneItem: PhoneData) {
        val detailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        detailActivityIntent.putExtra("phoneNumber", phoneItem.phone.toString())
        detailActivityIntent.putExtra("ContactName", phoneItem.contactName)
        startActivity(detailActivityIntent)
    }

    private fun createPhoneData() : List<PhoneData>{
        val list = ArrayList<PhoneData>()
        list.add(PhoneData(9864934321,"Alpin"))
        list.add(PhoneData(1341933131,"Bruno"))
        list.add(PhoneData(1401524342,"Ujang"))
        list.add(PhoneData(822123123,"Suep"))
        list.add(PhoneData(8213123414,"Markona"))
        list.add(PhoneData(892675631,"Juminten"))
        list.add(PhoneData(892675631,"Juminten"))
        list.add(PhoneData(78319791,"Ronaldo"))
        list.add(PhoneData(1243141343,"Inem"))
        list.add(PhoneData(8545452523,"Tukiem"))
        return list
    }
}