package com.example.user1.neilreading_300793474_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View v){

        Intent intent = new Intent(this,Ex1Activity.class);
        startActivity(intent);
    }

    public void onClick2(View v){

        Intent intent = new Intent(this,Ex2Activity.class);
        startActivity(intent);
    }

    public void onClick3(View v){

        Intent intent = new Intent(this,Ex3Activity.class);
        startActivity(intent);
    }

}
