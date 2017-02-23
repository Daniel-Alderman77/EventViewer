package com.example.danielalderman.eventviewer;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        webView = (WebView) findViewById(R.id.webViewWidget);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Retrieve the url that you put into your intent
        String url = getIntent().getStringExtra("URL");
        webView.loadUrl(url);
    }

}
