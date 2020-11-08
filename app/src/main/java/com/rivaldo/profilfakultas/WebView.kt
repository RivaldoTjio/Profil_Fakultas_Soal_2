package com.rivaldo.profilfakultas

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    private var link : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        link = intent.getStringExtra("link").toString()
        supportActionBar?.title = link
        settings()
        loadWebsite()
    }

    private fun settings() {
        val web_settings = webview.settings
        web_settings.javaScriptEnabled = true
        web_settings.allowContentAccess = true
        web_settings.useWideViewPort = true
        web_settings.loadsImagesAutomatically = true
        web_settings.cacheMode = WebSettings.LOAD_NO_CACHE
        web_settings.domStorageEnabled = true
    }

    private fun loadWebsite() {
        webview.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webview.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {

                super.onProgressChanged(view, newProgress)
            }
        }
        webview.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
        webview.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        link?.let { webview.loadUrl(it) }
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }

    }
}