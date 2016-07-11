package com.test.zlm.leakcanarydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.http.Url;

public class WeixinActivity extends AppCompatActivity  {

    WebView webView;
    private static final String APPID="wx9cf3c2618a1657e3";
    private static final String SECRET="57f02f04f35f616121e1be6cd3a0fef8";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin);
        webView= (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx9cf3c2618a1657e3&secret=57f02f04f35f616121e1be6cd3a0fef8";
//        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+SECRET+"&code=CODE&grant_type=authorization_code"





    }
}
