package com.example.brauzer

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup(){
        web_view.webViewClient = WebViewClient()
        web_view.apply {
            loadUrl("https:/www.google.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    var counter = 0

    override fun onBackPressed() {
        counter++
        if (web_view.canGoBack()) {
            web_view.goBack()
        }else if (counter==1){
            Toast.makeText(this, "chiqish uchun yana bosing", Toast.LENGTH_SHORT).show()
        }else{
            super.onBackPressed()
        }
    }
}
