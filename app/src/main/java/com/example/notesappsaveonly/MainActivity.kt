package com.example.notesappsaveonly


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappsaveonly.Model.Notes

class MainActivity : AppCompatActivity() {
    private lateinit var db: DBHelper

    private lateinit var rvNotes: RecyclerView
    private lateinit var editText: EditText
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)

        editText = findViewById(R.id.tvNewNote)
        submitBtn = findViewById(R.id.btSubmit)
        submitBtn.setOnClickListener { postNote() }

        rvNotes = findViewById(R.id.rvNotes)
        updateRV()
    }

    private fun updateRV(){
        rvNotes.adapter = RVAdapter(this, getItemsList())
        rvNotes.layoutManager = LinearLayoutManager(this)
    }

    private fun getItemsList(): ArrayList<Notes>{
        return db.viewNotes()
    }

    private fun postNote(){
        db.addNote(Notes(0, editText.text.toString()))
        editText.text.clear()
        Toast.makeText(this, "Note Added", Toast.LENGTH_LONG).show()
        updateRV()
    }
}