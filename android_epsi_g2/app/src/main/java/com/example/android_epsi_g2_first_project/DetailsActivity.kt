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
            val studentName1=getString(R.string.student1_name)
            val studentEmail1=getString(R.string.student1_mail)
            showStudentActivity(studentName1, studentEmail1, "man");
        })

        // Student2 Button
        var buttonStudent2=findViewById<Button>(R.id.buttonStudent2)
        buttonStudent2.setOnClickListener(View.OnClickListener() {
            val studentName2=getString(R.string.student2_name)
            val studentEmail2=getString(R.string.student2_mail)
            showStudentActivity(studentName2, studentEmail2, "man");
        })

        // Student3 Button
        var buttonStudent3=findViewById<Button>(R.id.buttonStudent3)
        buttonStudent3.setOnClickListener(View.OnClickListener() {
            val studentName3=getString(R.string.student3_name)
            val studentEmail3=getString(R.string.student3_mail)
            showStudentActivity(studentName3, studentEmail3, "woman");
        })
    }

    private fun showStudentActivity(studentName:String,studentEmail:String, sex:String) {
        val newIntent = Intent(application, StudentActivity::class.java)
        newIntent.putExtra("studentName", studentName)
        newIntent.putExtra("studentEmail", studentEmail)
        newIntent.putExtra("sex", sex)
        startActivity(newIntent)
    }
}