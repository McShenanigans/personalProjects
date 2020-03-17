package com.example.tehash.tnr;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private FloatingActionButton shareBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        shareBtn = findViewById(R.id.ShareBtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, webView.getUrl());
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Send to:"));
            }
        });
        webView = findViewById(R.id.WebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.timesnewroman.ro/");
    }
    @Override
    public void onBackPressed(){
        if(webView.canGoBack())webView.goBack();
        else super.onBackPressed();
    }
}
