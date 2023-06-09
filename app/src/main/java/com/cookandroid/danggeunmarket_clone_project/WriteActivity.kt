package com.cookandroid.danggeunmarket_clone_project

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cookandroid.danggeunmarket_clone_project.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    private lateinit var dbHelper: DBHelper
    private lateinit var database: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // StatusBar 투명도 설정
        makeStatusBarTransparent()

        dbHelper = DBHelper(this, "resellData.db", null, 1)
        database = dbHelper.writableDatabase

        binding.writeComplete.setOnClickListener {
            val title = binding.writeTitle.text.toString()
            val content = binding.writeContent.text.toString()
            val placetime = "1초전"
            val cost = binding.writeCost.text.toString()

            var query = "INSERT INTO resellData ('image', 'title', 'placetime', 'content', 'cost', 'likeNum') VALUES (" +
                    null + ", '" + title + "', '" + placetime + "', '" + content + "', '" + cost + "', " +
                    0 + ");";
            database.execSQL(query)

            Log.d("WRITETEST", "SUCCESS2")

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        // toolbar back btn
        binding.chatBackBtn.setOnClickListener {
            finish()
        }


    }
}