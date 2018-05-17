package com.example.bookolik.hobies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class acilis extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilis);



        iv=findViewById(R.id.imageView);
      //   Animation anim = AnimationUtils.loadAnimation(this,R.anim.acilisanim);
        final Intent i= new Intent(this,MainActivity.class);
        Thread zamanlama= new Thread(){


            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        zamanlama.start();
    }
}
