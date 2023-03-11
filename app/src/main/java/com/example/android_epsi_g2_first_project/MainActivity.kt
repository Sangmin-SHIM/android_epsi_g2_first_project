package com.example.android_epsi_g2_first_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle(getString(R.string.main_title))

        // Info Button
        var buttonInfo=findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener(View.OnClickListener() {
            val newIntent = Intent(application, DetailsActivity::class.java)
            startActivity(newIntent)
            })

        // Products Button
        val productInfoBtn = findViewById<Button>(R.id.buttonProduct)
        productInfoBtn.setOnClickListener(View.OnClickListener() {
            val newIntent = Intent(application, CategoriesActivity::class.java)
            startActivity(newIntent)
        })
    }
}