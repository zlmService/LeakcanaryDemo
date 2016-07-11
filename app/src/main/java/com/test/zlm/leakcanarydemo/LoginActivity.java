package com.test.zlm.leakcanarydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.test.zlm.leakcanarydemo.model.Token;

public class LoginActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn= (Button) findViewById(R.id.btn_login);
        requestQueue = Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();

            }
        });
    }

    public void init(){
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx9cf3c2618a1657e3&secret=57f02f04f35f616121e1be6cd3a0fef8";
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("AA:",response);
                Gson gson=new Gson();
                Token token = gson.fromJson(response,Token.class);
                String access_token = token.getAccess_token();
//                String token1 = token.getAccess_token();
                Log.e("token===",access_token);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("BB:",error.toString());
            }
        });

        requestQueue.add(request);
    }

}
