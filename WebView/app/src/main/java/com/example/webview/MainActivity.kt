package com.example.webview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var ed1: EditText
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webView=findViewById<WebView>(R.id.web)
        ed1=findViewById<EditText>(R.id.ed1)
        btn=findViewById<Button>(R.id.btn)



        webView.webViewClient= WebViewClient()
        webView.settings.javaScriptEnabled=true
        webView.settings.domStorageEnabled=true

        btn.setOnClickListener {
            var url=ed1.text.toString()
            url="https://$url"
            webView.loadUrl(url)

        }
    }
}