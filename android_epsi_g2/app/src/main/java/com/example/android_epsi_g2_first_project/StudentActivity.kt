package com.example.android_epsi_g2_first_project

import android.os.Bundle

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        setHeaderTitle(getString(R.string.info_student))
        showBack()

    }
}