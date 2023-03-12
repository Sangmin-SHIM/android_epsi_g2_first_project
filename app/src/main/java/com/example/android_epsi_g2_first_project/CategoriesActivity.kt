package com.example.android_epsi_g2_first_project

import android.content.Intent
import android.os.Bundle
import android.view.View
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

        val categoryListView = findViewById<ListView>(R.id.categoryList)

        val activeCategory = intent.getStringExtra("categoryTitle").toString()

        if (activeCategory != "null") {
            categoryListView.visibility = View.GONE

            setHeaderTitle(activeCategory)
            val jsonProductObject = JSONObject(intent.getStringExtra("categoryData").toString())

            getListFromWebService(jsonProductObject.get("products_url").toString()){ products ->
                val productNameList = ArrayList<String>()
                for (i in 0 until products.size) {
                    val item = JSONObject(products[i].toString())
                    productNameList.add(item.get("name").toString())
                }

                runOnUiThread {
                    val adapter = ArrayAdapter(this, R.layout.list_products, R.id.listProductTitle, productNameList)
                    categoryListView.adapter = adapter

                    categoryListView.visibility = View.VISIBLE
                }

                categoryListView.setOnItemClickListener { _, _, position, _ ->
                    val product = products[position].toString()

                    val intent = Intent(this, ProductActivity::class.java)
                    intent.putExtra("productData", product)

                    startActivity(intent)
                }
            }
        }
        else {
            categoryListView.visibility = View.VISIBLE

            getListFromWebService("https://www.ugarit.online/epsi/categories.json"){ categories ->
                val titleList = ArrayList<String>()
                for (i in 0 until categories.size) {
                    val item = JSONObject(categories[i].toString())
                    titleList.add(item.get("title").toString())
                }

                runOnUiThread {
                    val adapter = ArrayAdapter(this, R.layout.list_categories, titleList)
                    categoryListView.adapter = adapter
                }

                categoryListView.setOnItemClickListener { _, _, position, _ ->
                    val category = JSONObject(categories[position].toString())
                    val intent = Intent(this, CategoriesActivity::class.java)

                    intent.putExtra("categoryTitle", category.get("title").toString())
                    intent.putExtra("categoryData", category.toString())

                    startActivity(intent)
                }
            }
        }
    }

    private fun getListFromWebService(url: String, callback: (ArrayList<Any>) -> Unit) {
        val categoryList = ArrayList<Any>()
        Thread {
            val webServiceURL = URL(url)

            val connection = webServiceURL.openConnection()
            val jsonData = connection.inputStream.bufferedReader().readText()

            val jsonObject = JSONObject(jsonData)
            val items = jsonObject.getJSONArray("items")

            for (i in 0 until items.length()) {
                val item = items.getJSONObject(i)
                categoryList.add(item)
            }

            callback(categoryList)
        }.start()
    }
}
