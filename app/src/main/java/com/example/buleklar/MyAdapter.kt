package com.example.buleklar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(ListItem : ArrayList<ItemContent>, context : Context) :RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listItem : ArrayList<ItemContent> = ListItem
    var contextR = context
    class ViewHolder(view : View) :RecyclerView.ViewHolder(view){
        val tv_title = view.findViewById<TextView>(R.id.tv_title)
        val tv_price = view.findViewById<TextView>(R.id.tv_price)
        val im = view.findViewById<ImageView>(R.id.iv_icon)
        fun bind(listItem:ItemContent, context: Context){
            tv_title?.text = listItem.title
            tv_price?.text = listItem.price
            im.setImageResource(listItem.imageId)
            itemView.setOnClickListener() {
                Toast.makeText(context, "Pressed : ${tv_title.text}", Toast.LENGTH_SHORT).show()
                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", tv_title.text.toString())
                    putExtra("price", tv_price.text.toString())
                    putExtra("structure", listItem.structure)
                    putExtra("image",listItem.imageId)
                }
                context.startActivity(i)
            }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder((inflater.inflate((R.layout.item_layout), parent, false)))
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItem[position]
        holder.bind(listItem, contextR)
    }

    fun update(listArray : ArrayList<ItemContent>){
        listItem.clear()
        listItem.addAll(listArray)
        notifyDataSetChanged()
    }
}