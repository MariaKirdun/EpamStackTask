package com.example.stacktask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val stack : Stack<String>? = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StackPushButton.setOnClickListener{
            val newElement = StackEditText.text.toString()
            stack?.push(newElement)
            StackList.text = stack.toString()
        }

        StackPopButton.setOnClickListener {
            try {
                stack?.pop()
                StackList.text = stack.toString()
            } catch (e : EmptyStackExeption){
                StackList.text = e.message
            }
        }
    }
}
