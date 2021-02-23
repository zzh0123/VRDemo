package com.zzh.vrdemo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by 張鵬輝 on 2017/8/29.
 *
 * E-mail: 1344670918@qq.com
 *
 * CSDN: http://blog.csdn.net/QingTianGG
 *
 * 有问题欢迎随时来找我共同解决
 */
public class WebViewActivity extends AppCompatActivity {
    private com.tencent.smtt.sdk.WebView tencent_webview;
    private String url = "file:///android_asset/admin.html";
    private boolean isLoadUrl = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        tencent_webview = (WebView) findViewById(R.id.web);
        WebSettings webSettings = tencent_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        tencent_webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                Log.i("zzz1", "onPageStarted ");
                if(!isLoadUrl) {
                    isLoadUrl = true;
                    tencent_webview.loadUrl(url);
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i("zzz1", "shouldOverrideUrlLoading " + url);
                isLoadUrl = true;
                return true;
            }
        });
        tencent_webview.loadUrl(url);
    }
}
