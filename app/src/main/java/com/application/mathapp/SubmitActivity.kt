package com.application.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_submit.*

class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        val name = intent.getStringExtra("name")

        textView7.text = name

        if(name == "DATE"){
            textView9_data.visibility = View.VISIBLE
            textView9_data_.visibility = View.VISIBLE
            textView19.visibility = View.VISIBLE
            textView9.visibility = View.GONE
        }else{
            textView9_data.visibility = View.GONE
            textView9_data_.visibility = View.GONE
            textView19.visibility = View.GONE
            textView9.visibility = View.VISIBLE
        }

        textView11.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        imageView11.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        imageView10.setOnClickListener {
            var month = textView9_data.text.toString()
            if (month == "01" || month == "02" || month == "03" || month == "04" || month == "05" || month == "06" || month == "07" || month == "08" || month == "09") {
                month = textView9_data.text.toString().substringAfter("0")
            } else {
                month = textView9_data.text.toString()
            }
            var day = textView9_data_.text.toString()
            if (day == "01" || day == "02" || day == "03" || day == "04" || day == "05" || day == "07" || day == "06" || day == "08" || day == "09") {
                day = textView9_data_.text.toString().substringAfter("0")
            } else {
                day = textView9_data_.text.toString()
            }
            if (name == "DATE") {
                if (month.toInt() <= 12) {
                    if (day.toInt() <= 31) {
                        val number = textView9.text.toString()
                        val intent = Intent(this, PreSaveActivity::class.java)
                        intent.putExtra("number", number)
                        if (name == "MATH") {
                            intent.putExtra("type", "math")
                        } else if (name == "TRIVIA") {
                            intent.putExtra("type", "")
                        } else if (name == "DATE") {
                            intent.putExtra("type", "data")
                            intent.putExtra("month", month)
                            intent.putExtra("day", day)
                        }
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "A month cannot have more than 31 days.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this, "Cannot be more than 12 months.", Toast.LENGTH_SHORT)
                        .show()
                }
            }else{
                val number = textView9.text.toString()
                val intent = Intent(this, PreSaveActivity::class.java)
                intent.putExtra("number", number)
                if (name == "MATH") {
                    intent.putExtra("type", "math")
                } else if (name == "TRIVIA") {
                    intent.putExtra("type", "")
                }
                startActivity(intent)
            }
        }

        textView10.setOnClickListener {
            var month = textView9_data.text.toString()
            if (month == "01" || month == "02" || month == "03" || month == "04" || month == "05" || month == "06" || month == "07" || month == "08" || month == "09") {
                month = textView9_data.text.toString().substringAfter("0")
            } else {
                month = textView9_data.text.toString()
            }
            var day = textView9_data_.text.toString()
            if (day == "01" || day == "02" || day == "03" || day == "04" || day == "05" || day == "07" || day == "06" || day == "08" || day == "09") {
                day = textView9_data_.text.toString().substringAfter("0")
            } else {
                day = textView9_data_.text.toString()
            }
            if (name == "DATE") {
                if (month.toInt() <= 12) {
                    if (day.toInt() <= 31) {
                        val number = textView9.text.toString()
                        val intent = Intent(this, PreSaveActivity::class.java)
                        intent.putExtra("number", number)
                        if (name == "MATH") {
                            intent.putExtra("type", "math")
                        } else if (name == "TRIVIA") {
                            intent.putExtra("type", "")
                        } else if (name == "DATE") {
                            intent.putExtra("type", "data")
                            intent.putExtra("month", month)
                            intent.putExtra("day", day)
                        }
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "A month cannot have more than 31 days.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this, "Cannot be more than 12 months.", Toast.LENGTH_SHORT)
                        .show()
                }
            }else{
                val number = textView9.text.toString()
                val intent = Intent(this, PreSaveActivity::class.java)
                intent.putExtra("number", number)
                if (name == "MATH") {
                    intent.putExtra("type", "math")
                } else if (name == "TRIVIA") {
                    intent.putExtra("type", "")
                }
                startActivity(intent)
            }
        }
    }
}