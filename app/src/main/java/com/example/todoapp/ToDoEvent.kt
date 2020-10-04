package com.example.todoapp

import java.io.Serializable

data class ToDoEvent(var date_when: String, var place: String, var description: String, var with_whom: String) : Serializable {


}