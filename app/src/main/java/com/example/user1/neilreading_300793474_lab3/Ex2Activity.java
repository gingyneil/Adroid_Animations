package com.example.user1.neilreading_300793474_lab3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Ex2Activity extends AppCompatActivity {

        AnimationDrawable mframeAnimation = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.buttonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.buttonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }


    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.ImageView_Boy);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.boy1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.boy2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.boy3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.boy4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.boy5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.boy6);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);


        img.setBackgroundDrawable(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }
}
