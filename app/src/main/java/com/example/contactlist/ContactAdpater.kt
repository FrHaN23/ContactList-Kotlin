package com.example.contactlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (val phoneItemList: List<PhoneData>, val clickListener: (PhoneData) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.contant_list_item,parent,false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(phoneItemList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return phoneItemList.size
    }

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(phone:PhoneData,clickListener: (PhoneData) -> Unit){
            itemView.findViewById<TextView>(R.id.tv_part_item_name).text = phone.contactName
            itemView.findViewById<TextView>(R.id.tv_part_item_id).text = phone.phone.toString()
            itemView.setOnClickListener {clickListener(phone)}
        }
    }
}