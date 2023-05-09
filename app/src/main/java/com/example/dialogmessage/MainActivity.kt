package com.example.dialogmessage

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var showToast: Button
    private lateinit var showSnackbar: Button
    lateinit var myLayout: ConstraintLayout
    lateinit var myDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast = findViewById(R.id.buttonShowToast)
        showSnackbar = findViewById(R.id.buttonSnackbar2)
        myLayout = findViewById(R.id.myLayout)
        myDialog = findViewById(R.id.buttonDialog)

        showToast.setOnClickListener {
            Toast.makeText(applicationContext, "This a Toast Message", Toast.LENGTH_SHORT).show()
        }
        showSnackbar.setOnClickListener {
            Snackbar.make(myLayout, "This ís a Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Close", View.OnClickListener { }).show()
        }

        myDialog.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        var alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Change")
            .setMessage("Do you want to change the text of the button?")
            .setIcon(R.drawable.ic_baseline_warning_24)
            .setCancelable(false)  //user can not press back on display
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, _ ->
                dialogInterface.cancel()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                myDialog.text = "Nguyen Phuong Dong"
            })
        alertDialog.create().show()
    }
}