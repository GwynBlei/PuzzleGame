package ru.mggtk.puzzlegame

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.GridLayout
import android.widget.GridView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.util.Date

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val am = assets
        try {
            val files = am.list("img")
            val grid = findViewById<GridView>(R.id.grid)

            grid.adapter = ImageAdapter(this@MainActivity)
            grid.onItemClickListener = AdapterView
                .OnItemClickListener { adapterView, view, i, l ->

                    val intent = Intent(applicationContext, PuzzleActivity::class.java)
                    intent.putExtra("assetName", files!![i % files.size])
                    startActivity(intent)
                }



        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this@MainActivity, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }


    }









}