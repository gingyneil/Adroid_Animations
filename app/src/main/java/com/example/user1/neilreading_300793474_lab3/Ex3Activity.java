package com.example.user1.neilreading_300793474_lab3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Ex3Activity extends AppCompatActivity {


     ImageView  moonImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
    }



    public void startBtnClick(View view) {

        // animate the image
        moonImage = (ImageView) findViewById(R.id.moonImageView);

        // load the circleme.XML animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.circleme);




        moonImage.startAnimation(animation);


    }

        public void stopBtnClick(View view) {
        moonImage.clearAnimation();
    }
}
