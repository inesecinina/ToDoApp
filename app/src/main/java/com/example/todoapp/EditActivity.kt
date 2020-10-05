package com.example.todoapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.edit_activity.*
import kotlinx.android.synthetic.main.item_todo.*
import java.text.SimpleDateFormat
import java.util.*


class EditActivity : AppCompatActivity() {
    private var idx: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        idx = intent.getIntExtra("pozicija", -1)

        setContentView(R.layout.edit_activity)
        val editView: EditText  = findViewById(R.id.when_edit)
        //editView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            editView.setText(sdf.format(cal.time))
        }


        if (idx != -1) {
            val event = intent.getSerializableExtra("dati") as ToDoEvent
            setEvent(event)
        }
            editView.setOnClickListener {
                DatePickerDialog(this@EditActivity, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
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

