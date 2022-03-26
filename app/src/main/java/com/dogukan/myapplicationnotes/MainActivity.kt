package com.dogukan.myapplicationnotes

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences(
            "note", Context.MODE_PRIVATE);

        var text: String? = sharedPreferences.getString("note","")

        val editTextTextMultiLine:EditText = findViewById(R.id.editTextTextMultiLine)

        if (text != null)
            editTextTextMultiLine.text.append(text)

    }

    fun saveNote(view: View){
        val editTextTextMultiLine:EditText = findViewById(R.id.editTextTextMultiLine)
        sharedPreferences = this.getSharedPreferences("note" ,
            Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("note",
            editTextTextMultiLine.text.toString()).apply()
        println("kayıt edildi + ${editTextTextMultiLine.text.toString()}")
    }
}