package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*


class ToDoEventAdapter (private val events: MutableList<ToDoEvent>) :
    RecyclerView.Adapter<ToDoEventAdapter.ToDoViewHolder>(){

    class ToDoViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ToDoViewHolder(view)
    }
    override fun getItemCount() = events.size

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val event = events[position]
        val context = holder.itemView.context
        holder.itemView.when_text.text = event.date_when
        holder.itemView.where_text.text = event.place
        holder.itemView.what_text.text = event.description
        holder.itemView.with_whom_text.text = event.with_whom

        holder.itemView.remove.setOnClickListener {
            events.removeAt(position)
            notifyDataSetChanged()
        }
        holder.itemView.fix.setOnClickListener{

        }

    }
}