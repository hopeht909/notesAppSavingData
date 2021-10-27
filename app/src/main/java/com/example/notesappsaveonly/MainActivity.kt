package com.example.notesappsaveonly


import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    private fun editNote(noteID: Int, noteText: String){
        db.updateNote(Notes(noteID, noteText))
        updateRV()
    }
    fun deleteNote(noteID: Int){
        db.deleteNote(Notes(noteID, ""))
        updateRV()
    }
    
    fun raiseDialog(id: Int){
        val dialogBuilder = AlertDialog.Builder(this)
        val updatedNote = EditText(this)
        updatedNote.hint = "Enter new text"
        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("Save", DialogInterface.OnClickListener {
                    _, _ -> editNote(id, updatedNote.text.toString())
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, _ -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Update Note")
        alert.setView(updatedNote)
        alert.show()
    }
}