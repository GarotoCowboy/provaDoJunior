package br.com.pedro.exercicio1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner: Spinner = findViewById(R.id.spinner)
        val containerLayout: LinearLayout = findViewById(R.id.containerLayout)
        val amber = resources.getStringArray(R.array.Amber)



        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                containerLayout.removeAllViews()
                when(position){
                    0-> {
                        amber.forEach { beer ->
                            val textView = TextView(this@MainActivity)
                            textView.text = beer
                            containerLayout.addView(textView)
                        }
//                        val textView = TextView(this@MainActivity)
//                        textView.text = R.array.Amber.toString()
//                        containerLayout.addView(textView)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
//
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.beer_colors,
//            android.R.layout.simple_spinner_item
//        ).also { arrayAdapter ->
//
//            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = arrayAdapter
//        }
    }
}