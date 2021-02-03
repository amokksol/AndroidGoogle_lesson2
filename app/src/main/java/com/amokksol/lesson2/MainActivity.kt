package com.amokksol.lesson2

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener { addNickname(it) }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener { updateNickname(it) }

    }
    /*функция View - где view - это наша кнопка DOne, считывает вводимый текст из EditText - передает в скрытое текстовое значение,
    после передачи скрываем EditText и кнопку Done И делаем видимым скрытое текстовое значение, закрываем после нажатия кнопки клавиатуру*/
    private fun addNickname(view: View){
        //объявляем текстовый ввод пользователфя
        val editText = findViewById<EditText>(R.id.nickname_edit)
        //объявляем текстовое представление, которое в данный момент скрыто
        val nicknameTextView=findViewById<TextView>(R.id.nickname_text)
        //передаем значение из Edit Text в текстовое представление
        nicknameTextView.text = editText.text
        //скрываем текстовое поле ввода
        editText.visibility = View.GONE
        //скрываем кнопку
        view.visibility=View.GONE
        //делаем видимым текстDFF
        nicknameTextView.visibility=View.VISIBLE

        //скрываем клавиатуру после ввода
        val hideKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboard.hideSoftInputFromWindow(view.windowToken,0)
    }
    private fun updateNickname(view:View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.button)

        editText.visibility=View.VISIBLE
        doneButton.visibility=View.VISIBLE
        view.visibility=View.GONE
        //показываем - чт что у нас этот элемент может быть активным для пользователя
        editText.requestFocus()
        //делаем клавиатуру видимой
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText,0)
    }
}