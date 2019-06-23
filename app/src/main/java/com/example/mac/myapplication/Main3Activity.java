package com.example.mac.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import java.net.URL;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void op2(View btn){
        Intent nor = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bilibili.com/video/av48348061?from=search&seid=2715252718153415967"));
        startActivity(nor);
    }
    public void op3(View btn){
        Intent nor = new Intent(Intent.ACTION_VIEW, Uri.parse("https://music.163.com/#/song?id=444267215"));
        startActivity(nor);
    }
    public void op4(View btn){
        Intent nor = new Intent(this,FrameActivity.class);
        startActivity(nor);
    }

}
