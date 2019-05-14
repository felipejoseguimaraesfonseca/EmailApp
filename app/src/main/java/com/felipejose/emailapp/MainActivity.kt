package com.felipejose.emailapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoEmail = findViewById<Button>(R.id.botaoEmail) as Button

        botaoEmail.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("Email")
            val email_array = arrayOf("test1@gmail.com", "test2@gmail.com", "test3@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL,email_array)
            intent.putExtra(Intent.EXTRA_SUBJECT,"Esse campo é para o assunto.")
            intent.putExtra(Intent.EXTRA_TEXT, "Esse campo é para o texto do Email.")
            intent.type = "message/rfc822"
            val a = Intent.createChooser(intent,"Enviar Email.")
            startActivity(a)
        }
    }
}
