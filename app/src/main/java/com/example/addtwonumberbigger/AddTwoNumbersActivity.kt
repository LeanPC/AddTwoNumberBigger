package com.example.addtwonumberbigger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class AddTwoNumbersActivity : AppCompatActivity() {
// por simplicidad no se armo un fragment por 1 pantalla solamente
// asi como tambien se puede usar dataBinding para no usar los findViewById

    private lateinit var numberRight: EditText
    private lateinit var numberLeft: EditText
    private lateinit var btnContinue: Button
    private lateinit var tvResult: TextView
    private var viewModel = AddTwoNumbersViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_two_number)
        configView()
    }

    private fun configView(){
        //aca puede usarse un factory para viewmodels, pero como solo existe 1....
        viewModel = ViewModelProvider(this).get(AddTwoNumbersViewModel::class.java)

        numberLeft = findViewById(R.id.etNumberLeft)
        numberRight = findViewById(R.id.etNumberRight)
        btnContinue = findViewById(R.id.btContinue)
        tvResult = findViewById(R.id.tvResult)

        btnContinue.setOnClickListener {
            viewModel.sum(numberLeft.text.toString(), numberRight.text.toString())
        }

        val observer: Observer<String> = Observer { result -> tvResult.text = result }
        viewModel.getResult().observe(this, observer)
    }
}