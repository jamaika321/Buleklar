package com.example.buleklar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*


class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        tv_title.text = intent.getStringExtra("title")
        tv_price.text = intent.getStringExtra("price")
        tv_structure.text = intent.getStringExtra("structure")
        imageView2.setImageResource(intent.getIntExtra("image",R.drawable.jentelman))

    }
}