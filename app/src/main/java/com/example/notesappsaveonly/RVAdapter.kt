package com.example.notesappsaveonly

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappsaveonly.Model.Notes

import com.example.notesappsaveonly.databinding.NotesRowBinding

class RVAdapter(
    private val activity: MainActivity,
    val note:ArrayList<Notes>): RecyclerView.Adapter<RVAdapter.ItemBinding>() {
    class ItemBinding (val bin : NotesRowBinding):RecyclerView.ViewHolder(bin.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBinding {
        return ItemBinding(NotesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemBinding, position: Int) {
        val notes = note[position]
        holder.bin.apply{
            textView.text= notes.noteText
        }
    }

    override fun getItemCount()=note.size


}