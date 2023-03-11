package com.example.android_epsi_g2_first_project

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        val studentName=intent.extras!!.getString("studentName")
        val studentEmail=intent.extras!!.getString("studentEmail")
        val sex=intent.extras!!.getString("sex")
        val image=findViewById<ImageView>(R.id.imageViewAvatar)

        if (sex.equals("man")){
            image.setBackgroundResource(R.drawable.man);
        } else {
            image.setBackgroundResource(R.drawable.woman);
        }
        val textStudentName = findViewById<TextView>(R.id.textStudentName)
        textStudentName.setText(studentName);

        val textStudentEmail = findViewById<TextView>(R.id.textStudentEmail)
        textStudentEmail.setText(studentEmail);

        setHeaderTitle(getString(R.string.info_student))
        showBack()

    }
}