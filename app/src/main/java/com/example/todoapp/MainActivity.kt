package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AdapterClickListener {
    private val events = mutableListOf<ToDoEvent>(
        ToDoEvent("24.02.2021", "Mājas", "Jāmazgā grīda", "ar slotu"))
    private lateinit var adapter: ToDoEventAdapter

//    fun getAdapter() = adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ToDoEventAdapter(events, this)
        todo_list.adapter = adapter


        fab.setOnClickListener {
            startActivityForResult(Intent(this, EditActivity::class.java), 1234)
        }
    }

    override fun eventFixClicked(existingEventPosition: Int) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("dati", events[existingEventPosition])
        intent.putExtra("pozicija", existingEventPosition)
        startActivityForResult(intent, 4321)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234 && resultCode == RESULT_OK && data != null) {
            val newEvent = data.getSerializableExtra("dati") as ToDoEvent
            events.add(newEvent)
            adapter.notifyDataSetChanged()
        } else if (requestCode == 4321 && resultCode == RESULT_OK && data != null) {
            val existingEventPosition = data.getIntExtra("pozicija", -1)
            val existingEvent = data.getSerializableExtra("dati") as ToDoEvent

            Log.d("TAG-A", data.toString())
            Log.d("TAG-A", existingEventPosition.toString())
            Log.d("TAG-B", existingEvent.toString())
            events.set(existingEventPosition, existingEvent)
            adapter.notifyDataSetChanged()
        }


    }

}


interface AdapterClickListener {
    fun eventFixClicked(existingEventPosition: Int)
}