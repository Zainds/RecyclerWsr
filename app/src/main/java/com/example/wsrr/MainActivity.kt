package com.example.wsrr

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        RecyclerView.layoutManager = LinearLayoutManager(baseContext)
        RecyclerView.adapter = MyAdapter().apply {
            items = MutableList(10, {
                Item((String(Random.nextBytes(30))),
                R.drawable.ic_launcher_background)
            })
        }
    }
}

class MyAdapter: RecyclerView.Adapter<MyAdapter.Companion.MyViewHolder>(){

    var items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.onBind(items[position])
    }

    override fun getItemCount(): Int = items.size

    companion object{
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val textView = itemView.findViewById<TextView>(R.id.textView)
         val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun onBind(item: Item){
            textView.text = item.str
            imageView.setImageResource(item.img)
        }
        }
    }
}
data class Item(val str: String, val img: Int)