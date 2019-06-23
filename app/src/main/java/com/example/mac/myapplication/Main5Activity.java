package com.example.mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
    public void op111(View btn){
        Intent nor = new Intent(this,Main3Activity.class);
        startActivity(nor);
    }
    public void op222(View btn){
        Intent nor = new Intent(this,Main7Activity.class);
        startActivity(nor);
    }
}
