package com.harsh.assignmentalertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

import com.harsh.assignmentalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.btnCalculate?.setOnClickListener {
            if (binding?.no?.text.toString().trim().isNullOrEmpty()) {
                binding?.no?.error = "enter number"
            } else {
                var number = binding?.no?.text?.toString()?.toDouble() ?: 0.0
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Perform calculation")
                alertDialog.setMessage("Add 10 to${binding?.no?.text}\nSub 10 to${binding?.no?.text}\nReset${binding?.no?.text}")
                alertDialog.setCancelable(false)
                alertDialog.setPositiveButton("Add ${binding?.no?.text}") { _, _ ->
                    binding?.no?.setText((number + number).toString())
                    Toast.makeText(this, "postive button clicked", Toast.LENGTH_LONG).show()
                }
                alertDialog.setNegativeButton("Sub ${binding?.no?.text}") { _, _ ->
                    binding?.no?.setText((number - number).toString())
                    Toast.makeText(this, "Negative button clicked", Toast.LENGTH_LONG).show()
                }
                alertDialog.setNeutralButton("Reset") { _, _ ->
                    binding?.no?.setText((0).toString())
                    Toast.makeText(this, "Reset Clicked", Toast.LENGTH_LONG).show()
                }
                alertDialog.show()
            }
        }
    }
}

