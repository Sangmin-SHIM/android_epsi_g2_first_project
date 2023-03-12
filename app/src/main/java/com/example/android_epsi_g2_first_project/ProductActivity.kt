package com.example.android_epsi_g2_first_project

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.json.JSONObject

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        showBack()

        val activeProduct = JSONObject(intent.getStringExtra("productData").toString())

        val imageViewProduct = findViewById<ImageView>(R.id.imageViewProduct)
        val textViewProductDescription = findViewById<TextView>(R.id.textViewProductDescription)

        setHeaderTitle(activeProduct.get("name").toString())
        textViewProductDescription.text = activeProduct.get("description").toString()

        Picasso.get().load(activeProduct.get("picture_url").toString()).into(imageViewProduct)
    }
}