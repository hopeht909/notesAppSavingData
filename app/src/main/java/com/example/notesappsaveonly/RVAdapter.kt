package com.example.notesappsaveonly

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappsaveonly.databinding.NotesRowBinding

class RVAdapter(val note:ArrayList<String>): RecyclerView.Adapter<RVAdapter.ItemBinding>() {
    class ItemBinding (val bin : NotesRowBinding):RecyclerView.ViewHolder(bin.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBinding {
        return ItemBinding(NotesRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemBinding, position: Int) {
        val notes = note[position]
        holder.bin.apply{
            textView.text= notes
        }
    }

    override fun getItemCount()=note.size


}