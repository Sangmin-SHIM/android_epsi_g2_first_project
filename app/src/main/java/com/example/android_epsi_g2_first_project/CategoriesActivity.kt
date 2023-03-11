package com.example.android_epsi_g2_first_project

import android.os.Bundle
import android.util.Log
import org.json.JSONObject
import java.net.URL

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle(getString(R.string.products_title))
        showBack()

        getRaysFromWebservice("https://www.ugarit.online/epsi/categories.json");
    }

    //Fonction qui récupère les rayons depuis le webservice
    fun getRaysFromWebservice(url: String): ArrayList<String> {
        //Déclaration de la liste des rayons
        val rayList = ArrayList<String>()

        //Création d'un thread séparé pour effectuer l'appel au webservice
        val thread = Thread {
            //Création de l'objet URL à partir de l'url passée en paramètre
            val webServiceURL = URL(url)

            //Récupération du contenu JSON
            val connection = webServiceURL.openConnection()
            val jsonData = connection.inputStream.bufferedReader().readText()

            //Parsing du JSON et récupération des rayons
            val jsonObject = JSONObject(jsonData)
            val rayons = jsonObject.getJSONArray("items")

            for (i in 0 until rayons.length()) {
                val rayon = rayons.getJSONObject(i)
                val rayonName = rayon.getString("title")
                rayList.add(rayonName)
            }

            //Affichage des rayons dans la log
            for (rayon in rayList) {
                Log.d("rayon", rayon)
            }
        }

        thread.start()

        return rayList
    }
}