package com.application.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_save.*

class SaveActivity : AppCompatActivity() {

    val adapter = rcAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        for (it in 1..8){
            val save = PreferenceManager.getDefaultSharedPreferences(this).getString("save$it", "")
            val type = PreferenceManager.getDefaultSharedPreferences(this).getString("type$it", "")
            val plant = Data(save!!,type!!)
            adapter.addPlant(plant)
            rc_view.layoutManager = LinearLayoutManager(this)
            rc_view.adapter = adapter
        }

        imageView18.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        textView18.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}