package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.edit_activity.*
import kotlinx.android.synthetic.main.item_todo.*



class EditActivity : AppCompatActivity() {
    private var idx: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        idx = intent.getIntExtra("pozicija", -1)

        setContentView(R.layout.edit_activity)

        if (idx != -1) {
            val event = intent.getSerializableExtra("dati") as ToDoEvent
            setEvent(event)
        }

        go_back.setOnClickListener { returnToMain() }
        save_changes.setOnClickListener { saveChanges() }
}
    private fun returnToMain() {
        this.finish()
    }

    private fun getEvent() = ToDoEvent(
        date_when = when_edit.text.toString(),
        place = where_edit.text.toString(),
        description = task_edit.text.toString(),
        with_whom = with_whom_edit.text.toString()
    )

    private fun setEvent(event: ToDoEvent) {
        when_edit.setText(event.date_when)
        where_edit.setText(event.place)
        task_edit.setText(event.description)
        with_whom_edit.setText(event.with_whom)
    }

    private fun saveChanges() {
        val newEvent = getEvent()
        val intent = Intent().putExtra("dati", newEvent)
        Log.d("TAG-X", idx.toString())
        if (idx != -1) {
            intent.putExtra("pozicija", idx)
        }
        setResult(RESULT_OK, intent)
        this.finish()
    }
    }

