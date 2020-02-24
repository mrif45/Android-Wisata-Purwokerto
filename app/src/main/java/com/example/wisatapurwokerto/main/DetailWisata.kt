package com.example.wisatapurwokerto.main

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisatapurwokerto.R

class DetailWisata : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Tempat Wisata"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val imgPhoto: ImageView = findViewById(R.id.img_item_wisata)
        val tvDetail: TextView = findViewById(R.id.tv_item_detail)
        val tvAddress: TextView = findViewById(R.id.tv_item_address)
        val tvTime: TextView = findViewById(R.id.tv_item_time)

        val tName = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tAddress = intent.getStringExtra(EXTRA_ADDRESS)
        val tTime = intent.getStringExtra(EXTRA_TIME)

        tvName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgPhoto)
        tvDetail.text = tDetail
        tvAddress.text = tAddress
        tvTime.text = tTime
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_ADDRESS = "extra_address"
        const val EXTRA_TIME = "extra_time"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}