package com.example.wisatapurwokerto.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisatapurwokerto.R
import com.example.wisatapurwokerto.adapter.CardViewWisataAdapter
import com.example.wisatapurwokerto.data.Wisata
import com.example.wisatapurwokerto.data.DataWisata

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata:RecyclerView
    private var title = "Wisata Purwokerto"
    private var list:ArrayList<Wisata> = arrayListOf()

    private fun showRecyclerCardView(){
        rvWisata.layoutManager = LinearLayoutManager(this)
        val cardViewWisataAdapter = CardViewWisataAdapter(list)
        rvWisata.adapter = cardViewWisataAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Wisata Purwokerto"
        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)

        list.addAll(DataWisata.listData)
        showRecyclerCardView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setAboutme(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setAboutme(selectedMode: Int){
        when (selectedMode) {
            R.id.ic_Profile -> {
                title = "Wisata Purwokerto"
                val iaboutme = Intent(this@MainActivity, Aboutme::class.java)
                startActivity(iaboutme)
            }
        }
    }
}

