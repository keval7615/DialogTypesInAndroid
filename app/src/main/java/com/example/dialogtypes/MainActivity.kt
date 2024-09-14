package com.example.dialogtypes

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogtypes.databinding.ActivityMainBinding
import com.example.dialogtypes.databinding.CustomeDialogLayoutBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lateinit var binding: ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Simple Alertbox dialogbox Example
        binding.btnAlertDialog.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert !!! ")


            builder.setMessage("Something happen Wrong")

            builder.setCancelable(false)

            builder.setPositiveButton("Restart") { dialog, which ->
                Toast.makeText(this, "Restart called", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Wait") { dialog, which ->
                Toast.makeText(this, "Wait called", Toast.LENGTH_SHORT).show()
            }
            val temp = builder.create()
            temp.show()
        }

//        Single choose Alertbox example

        binding.btnSingleChoiseDemo.setOnClickListener {

            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Choose any one")

            val array = arrayOf(
                "Student",
                "1 to 3 years Experience",
                "3 to 5 years Experience",
                "or more Experience"
            )

            alertDialog.setSingleChoiceItems(array, 0) { dialog, which ->
                Toast.makeText(this, "${array[which]} item chose", Toast.LENGTH_SHORT).show()

            }
            alertDialog.setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show()

            }
            alertDialog.create().show()
        }

//        Multi choose Alertbox example
        binding.btnMultichoice.setOnClickListener {
            val multiChoiceItems = arrayOf("sports", "music", "study", "adventure")
            val choiceAlertDialog = AlertDialog.Builder(this)
            val checkeded = booleanArrayOf(true, false, true, false)
            var list = mutableListOf("")

            choiceAlertDialog.setTitle("Select Your Area of Interest")

        //    choiceAlertDialog.setMessage("you can chose multiple option")
            choiceAlertDialog.setMultiChoiceItems(
                multiChoiceItems,
                checkeded
            ) { dialog, which, checked ->

                Toast.makeText(this, "${multiChoiceItems[which]}", Toast.LENGTH_SHORT).show()
                if (checked) {
                    list.add(multiChoiceItems[which])
                } else {
                    list.remove(multiChoiceItems[which])
                }

            }

            choiceAlertDialog.setNegativeButton("cancel") { dialog, which ->
                Toast.makeText(this, "Nothing choosed", Toast.LENGTH_SHORT).show()
            }
            choiceAlertDialog.setPositiveButton("Done") { dialog, which ->
                Toast.makeText(
                    this, "$list", Toast.LENGTH_SHORT
                ).show()
            }

            choiceAlertDialog.create().show()
        }

//        custome Dialog box Example
        
        binding.btnCustom.setOnClickListener {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()

            val bindingCd = CustomeDialogLayoutBinding.inflate(layoutInflater)
            val customBuilder = AlertDialog.Builder(this).setView(bindingCd.root)
            val dialog = customBuilder.create()

            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            bindingCd.imageView2.setOnClickListener {
                Toast.makeText(applicationContext, "Done Clicked", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            bindingCd.imageView3.setOnClickListener {
                dialog.dismiss()
            }


        }
        binding.btnNext.setOnClickListener {
            var intent = Intent(this,DateAndTimePicker::class.java)
            startActivity(intent)
        }

    }


}