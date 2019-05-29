package com.example.xia_day02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class XiangActivity extends AppCompatActivity {

    private WebView mWeb;
    private ProgressBar mPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        initView();
    }

    private void initView() {
        mWeb = (WebView) findViewById(R.id.web);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        mWeb.loadUrl(link);
        mPb = (ProgressBar) findViewById(R.id.pb);
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mPb.setProgress(newProgress);

            }
        });
        mWeb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }
}
