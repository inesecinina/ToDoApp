package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import lv.romstr.mobile.rtu_android.EditActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: FloatingActionButton = findViewById(R.id.fab)
        addButton.setOnClickListener{openEdit()}
    }
    private fun openEdit() {
        startActivity(Intent(this, EditActivity::class.java))
    }
}