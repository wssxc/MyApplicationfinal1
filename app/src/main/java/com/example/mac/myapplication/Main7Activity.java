package com.example.mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }

    public void op44(View btn){
        Intent nor = new Intent(this,MainActivity.class);
        startActivity(nor);
    }
    public void op33(View btn){
        Intent nor = new Intent(this,Main2Activity.class);
        startActivity(nor);
    }
    public void op22(View btn){
        Intent nor = new Intent(this,Main6Activity.class);
        startActivity(nor);
    }
}
