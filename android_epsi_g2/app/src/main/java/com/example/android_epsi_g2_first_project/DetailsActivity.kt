package com.example.android_epsi_g2_first_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setHeaderTitle(getString(R.string.info_title))
        showBack()

        // Student1 Button
        var buttonStudent1=findViewById<Button>(R.id.buttonStudent1)
        buttonStudent1.setOnClickListener(View.OnClickListener() {
            val newIntent1 = Intent(application, StudentActivity::class.java)
            startActivity(newIntent1)
        })

        // Student2 Button
        var buttonStudent2=findViewById<Button>(R.id.buttonStudent2)
        buttonStudent2.setOnClickListener(View.OnClickListener() {
            val newIntent2 = Intent(application, StudentActivity::class.java)
            startActivity(newIntent2)
        })

        // Student3 Button
        var buttonStudent3=findViewById<Button>(R.id.buttonStudent3)
        buttonStudent3.setOnClickListener(View.OnClickListener() {
            val newIntent3 = Intent(application, StudentActivity::class.java)
            startActivity(newIntent3)
        })
    }
}