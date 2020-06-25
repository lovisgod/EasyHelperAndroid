package com.lovisgod.easyhelper

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt = findViewById<TextView>(R.id.test)
        val btn = findViewById<Button>(R.id.sample_btn)
        val samEdit = findViewById<EditText>(R.id.sample_edit)
        val dialogBtn = findViewById<Button>(R.id.dialog_btn)

        val easySpanner = Spanner()
        val easyEH = TextHandler()
        val easyD = DailogHandler()
        easySpanner.makeClickableSpan({ easyD.makeSnack(txt, "This is the sample", this) }, Color.WHITE, true, txt, 0, 6, "Lovisgod")

        btn.setOnClickListener {
            if ( samEdit.text.toString().isEmpty()) {
                easyD.makeToast("This must not be empty", this, R.drawable.submit_bg)
                easyEH.setError(arrayOf(samEdit))
            }
            easyEH.setEmpty(arrayOf(samEdit))
        }

        dialogBtn.setOnClickListener {
            easyD.inflateDialog(this, R.layout.sample)?.show()

        }

    }

    fun handleAction (view: View) {
        val saveBtn = view.findViewById<Button>(R.id.button_)

        saveBtn.setOnClickListener {
            println("this is working")
        }
    }
}