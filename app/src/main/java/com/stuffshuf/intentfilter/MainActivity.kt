package com.stuffshuf.intentfilter

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnBrowse.setOnClickListener {
            val i = Intent()

            i.action = Intent.ACTION_VIEW
            // i.data=Uri.parse(etData.text.toString())
            if (!etData.text.toString().startsWith("https:")) {
                i.data = Uri.parse("https://" + etData.text.toString())


            } else {
                i.data = Uri.parse(etData.text.toString())
            }

            try {
                startActivity(i)

            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No App Found To Open This", Toast.LENGTH_LONG).show()
            }


        }
    }
}