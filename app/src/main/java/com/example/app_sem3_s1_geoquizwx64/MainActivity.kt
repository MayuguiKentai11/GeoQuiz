package com.example.app_sem3_s1_geoquizwx64

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val EXTRA_MESS = "com.example.app_sem3_s1_geoquizwx64.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun sendMessageLevel1(view : View){
        // Link the components to UI with logic

        val intent = Intent(this, Level1Activity::class.java)

        startActivity(intent)
    }

    fun sendMessageLevel2(view : View){
        // Link the components to UI with logic

        val intent = Intent(this, Level2Activity::class.java)

        startActivity(intent)
    }

    fun sendMessageLevel3(view : View){
        // Link the components to UI with logic

        val intent = Intent(this, Level3Activity::class.java)

        startActivity(intent)
    }
}