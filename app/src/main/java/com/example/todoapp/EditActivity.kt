package lv.romstr.mobile.rtu_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.R
import kotlinx.android.synthetic.main.edit_activity.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_activity)

        go_back.setOnClickListener { returnToMain() }
        save_changes.setOnClickListener { saveChanges() }
}
    private fun returnToMain() {
        this.finish()
    }

    private fun saveChanges() {

    }
    }

