package com.example.bookolik.hobies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class goruntuleme extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goruntuleme);
        webView=(WebView)findViewById(R.id.site);


    Bundle gelenveri=getIntent().getExtras();
    String Gelenyazi=gelenveri.getString("anahtar");
    String ana ="www";
      String linkilk=  Gelenyazi.substring(0,3).toString();





        switch (linkilk) {
            case "www": Gelenyazi="http://"+Gelenyazi;
                break;
            case "htt":
                break;
        default: Gelenyazi="http://www."+Gelenyazi;

            break;
        }


   /*   if(linkilk==ana){
        Toast.makeText(goruntuleme.this,linkilk,Toast.LENGTH_SHORT).show();
        Gelenyazi="http://"+Gelenyazi;

    }*/

    /*  else if (Gelenyazi.substring(0,2)!="www" && Gelenyazi.substring(0,3)!="http"){

         //   Gelenyazi="http://www."+Gelenyazi;
        }*/

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Gelenyazi);
        final ProgressDialog progressDialog = ProgressDialog.show(goruntuleme.this,"Hobies","Yükleniyor",true);
        progressDialog.show();

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);

                Toast.makeText(goruntuleme.this,"Sayfa Yüklendi",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
                super.onReceivedClientCertRequest(view, request);
                Toast.makeText(goruntuleme.this,"Bir hata oluştu",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

     /*   ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                *//*WebView webview = (WebView) findViewById(R.id.site);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.loadUrl("https://www.merlininkazani.com/");*//*
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);

            }
        });*/

    }
}
