package com.application.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView3.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","MATH")
            startActivity(intent)
        }

        imageView4.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","MATH")
            startActivity(intent)
        }

        imageView5.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","TRIVIA")
            startActivity(intent)
        }

        textView4.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","TRIVIA")
            startActivity(intent)
        }

        textView5.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","DATE")
            startActivity(intent)
        }

        imageView6.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","DATE")
            startActivity(intent)
        }

        imageView7.setOnClickListener {
            startActivity(Intent(this,SaveActivity::class.java))
        }

        textView6.setOnClickListener {
            startActivity(Intent(this,SaveActivity::class.java))
        }
    }
}