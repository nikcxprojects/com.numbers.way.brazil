package com.application.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_pre_save.*

class PreSaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_save)

        val type = intent.getStringExtra("type")
        val number = intent.getStringExtra("number")

        if(type == "math"){
            textView7.text = "MATH"
            callServer("http://numbersapi.com/$number/math")
        }else if(type == ""){
            textView7.text = "TRIVIA"
            callServer("http://numbersapi.com/$number")
        }else if(type == "data"){
            textView7.text = "DATA"
            val month = intent.getStringExtra("month")
            val day = intent.getStringExtra("day")
            callServer("http://numbersapi.com/$month/$day/date")
        }

        imageView13.setOnClickListener {
            val index = PreferenceManager.getDefaultSharedPreferences(this).getInt("index", 1)
            if(type == "data"){
                val month = intent.getStringExtra("month")
                val day = intent.getStringExtra("day")
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("save$index", "$month/$day").apply()
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("type$index", "$type").apply()
                if(index <= 8) {
                    val indexs = index + 1
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", indexs).apply()
                }else{
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", 1).apply()
                }
            }else{
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("save$index", number).apply()
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("type$index", "$type").apply()
                if(index <= 8) {
                    val indexs = index + 1
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", indexs).apply()
                }else{
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", 1).apply()
                }
            }
            startActivity(Intent(this,SaveActivity::class.java))
        }

        textView13.setOnClickListener {
            val index = PreferenceManager.getDefaultSharedPreferences(this).getInt("index", 1)
            if(type == "data"){
                val month = intent.getStringExtra("month")
                val day = intent.getStringExtra("day")
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("save$index", "$month/$day").apply()
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("type$index", "$type").apply()
                if(index <= 8) {
                    val indexs = index + 1
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", indexs).apply()
                }else{
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", 1).apply()
                }
            }else{
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("save$index", number).apply()
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("type$index", "$type").apply()
                if(index <= 8) {
                    val indexs = index + 1
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", indexs).apply()
                }else{
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putInt("index", 1).apply()
                }
            }
            startActivity(Intent(this,SaveActivity::class.java))
        }

        imageView14.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","MATH")
            startActivity(intent)
        }

        textView14.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","MATH")
            startActivity(intent)
        }

        textView15.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","TRIVIA")
            startActivity(intent)
        }

        imageView15.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","TRIVIA")
            startActivity(intent)
        }

        imageView16.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","DATE")
            startActivity(intent)
        }

        textView16.setOnClickListener {
            val intent = Intent(this,SubmitActivity::class.java)
            intent.putExtra("name","DATE")
            startActivity(intent)
        }

    }

    private fun callServer(serve: String){
        val httpAsync = serve
            .httpGet()
            .timeout(20000)
            .header("Content-Type", "application/json; utf-8")
            .responseString { _, _, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.e("Error", "response error ${result.getException()}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        println(data)
                        Log.d("ashbjkasd",data)
                        val subtext = data.substringAfter("\"text\": \"")
                        val text = subtext.substringBefore("\"")
                        textView12.text = text + " \n\nAnother one?"
                    }
                }
            }
        httpAsync.join()
    }
}