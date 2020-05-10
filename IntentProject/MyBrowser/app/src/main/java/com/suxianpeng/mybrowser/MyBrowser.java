package com.suxianpeng.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class MyBrowser extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybrowser);

        Intent intent=getIntent();
        webView=findViewById(R.id.webview);

        Uri uri=intent.getData();
        webView.loadUrl(uri.toString());//将该WebView的url加载为从intent中获得的uri

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);//将webView中的url加载出来
                return true;
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);//设置其支持Javascript
    }
}
