package com.adrianedilao.notesapp

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    lateinit var toDoList: LinearLayout
    lateinit var userInput: EditText
    lateinit var checkedChangeListener: CompoundButton.OnCheckedChangeListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toDoList = findViewById(R.id.linear_layout_todolist)
        userInput = findViewById(R.id.et_entertodoactivity)
        checkedChangeListener = CompoundButton.OnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked){
                buttonView.paintFlags = buttonView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
    }

    fun addTodoActivity(view: View){
        val toDoItem = CheckBox(this) //declare inside the function so that u can create separate checkbox variables instead of creating a single checkbox outside the function and changing the value everytime u add a todo item
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        toDoItem.layoutParams = params
        toDoItem.text = userInput.text.toString()
        toDoList.addView(toDoItem)

        toDoItem.setOnCheckedChangeListener(checkedChangeListener) //checkedChangeListener is our listener here
    }

    fun clearTodoActivity(view: View){
        toDoList.removeAllViews()
    }
}