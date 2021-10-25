package com.example.notesappsaveonly


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var ed:EditText
    lateinit var bt:Button
    lateinit var rc:RecyclerView
    lateinit var list:ArrayList<String>
    var s1=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rc=findViewById(R.id.RVv)
        ed=findViewById(R.id.editTextTextPersonName)
        bt=findViewById(R.id.button)

        bt.setOnClickListener {
            s1=ed.text.toString()
            val dbhr =DBHelper(this)
            val status = dbhr.savedata(s1)
            Toast.makeText(applicationContext, "data Saved$status", Toast.LENGTH_SHORT).show()
            ed.text.clear()
            ed.clearFocus()

        }

    }}