package eu.tutorials.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get button reference
        var btnDatePicker: Button = findViewById<Button>(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener{ view ->
            clickDatePicker(view)
        }


    }

    // function that converts date to minutes
    fun ageInMinutes(date: Date): Int {
        val currentDate = Calendar.getInstance().time
        val diff = currentDate.time - date.time
        return (diff / (1000 * 60)).toInt()
    }

    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        

        var tvSelectedDate: TextView = findViewById<TextView>(R.id.tvSelectedDate)
        var ageInMinutes: TextView = findViewById<TextView>(R.id.ageInMinutes)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
//                Toast.makeText(this, "The chosen year is $year, the month is $month, and the day is $dayOfMonth", Toast.LENGTH_LONG).show()
                val selectedDate = "$dayOfMonth/${month+1}/$year"
                tvSelectedDate.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val minutes = ageInMinutes(sdf.parse(selectedDate))

                ageInMinutes.text = minutes.toString()


            },

            year,
            month,
            day
        ).show()


        }


    
}