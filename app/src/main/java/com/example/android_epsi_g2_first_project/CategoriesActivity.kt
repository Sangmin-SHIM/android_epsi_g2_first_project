package com.example.android_epsi_g2_first_project

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONObject
import java.net.URL
import java.util.*


class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle(getString(R.string.products_title))
        showBack()

        val categoryList = findViewById<ListView>(R.id.categoryList)

        getRayonsFromWebservice { rayList ->
            runOnUiThread {
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, rayList)
                categoryList.adapter = adapter
            }

            categoryList.setOnItemClickListener {_, _, position, _ ->
                val category = rayList[position]
                val intent = Intent(this, CategoriesActivity::class.java)
                intent.putExtra("category", category)
                startActivity(intent)
            }
        }
    }

    private fun getRayonsFromWebservice(callback: (ArrayList<String>) -> Unit) {
        val rayList = ArrayList<String>()
        Thread {
            val webServiceURL = URL("https://www.ugarit.online/epsi/categories.json")

            val connection = webServiceURL.openConnection()
            val jsonData = connection.inputStream.bufferedReader().readText()

            val jsonObject = JSONObject(jsonData)
            val rayons = jsonObject.getJSONArray("items")

            for (i in 0 until rayons.length()) {
                val rayon = rayons.getJSONObject(i)
                rayList.add(rayon.getString("title"))
            }

            callback(rayList)
        }.start()
    }
}