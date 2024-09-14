package com.example.dialogtypes

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogtypes.databinding.ActivityDateAndTimePickerBinding

class DateAndTimePicker : AppCompatActivity() {
    private lateinit var binding: ActivityDateAndTimePickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_date_and_time_picker)

        binding = ActivityDateAndTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val current = Calendar.getInstance()
        var crntDay = current.get(Calendar.DAY_OF_MONTH)
        var crntMonth = current.get(Calendar.MONTH)
        var crntYear = current.get(Calendar.YEAR)
        var crntMinut =current.get(Calendar.MINUTE)
        var crntHour =current.get(Calendar.HOUR_OF_DAY)

        var selectedDate:String= ""
        binding.ivDatePicker.setOnClickListener{

//        date picker
            DatePickerDialog(this,{ datepicker:DatePicker, year:Int,month:Int,day:Int ->
                selectedDate = "${ day.toString().padStart(2, '0') }/" +
                        "${month.toString().padStart(2,'0')}/" +
                        "${year.toString()}"
                Toast.makeText(this, "$year/$month/$day", Toast.LENGTH_SHORT).show()
//                to set last selected  value always
                crntDay = day
                crntMonth= month
                crntYear= year

                binding.etDateShow.setText(selectedDate)
            },crntYear,crntMonth,crntDay).show()
        }

//        timepicker
        binding.ivTimePicker.setOnClickListener{

            val timepicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener{
                timePicker, hour, minute ->
                var selectedTime = " ${hour.toString().padStart(2,'0')} : ${minute.toString().padStart(2,'0')}"
                crntHour=hour
                crntMinut=minute
                binding.etDateShow.setText(selectedDate.plus(selectedTime))
            }
                ,crntHour,crntMinut,false).show()
        }

    }
}