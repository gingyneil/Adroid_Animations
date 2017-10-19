package com.example.user1.neilreading_300793474_lab3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class Ex1Activity extends AppCompatActivity {
    ///controls and views

    //spinner to select font
    Spinner spinnerUse;
    Spinner spinnerColor;
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    ImageView reusableImageView;
    //TextView textView;

    //
    int startx = 10;
    int starty = 10;
    int endx = 10;
    int endy = 10;

    String pressed;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

    //Spinner for the fonts
        spinnerUse = (Spinner) findViewById(R.id.spinner2);
        String text = spinnerUse.getSelectedItem().toString();

        //Spinner for the color
        spinnerColor = (Spinner)findViewById(R.id.spinnerColor);
        String cl = spinnerColor.getSelectedItem().toString();


        //change string to float
        float font = Float.valueOf(text);

        // create paint object to draw with
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(font);

        //Creating a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap((int) getWindowManager().getDefaultDisplay().getWidth(),
                (int) getWindowManager().getDefaultDisplay().getHeight(),Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);
        reusableImageView = (ImageView)findViewById(R.id.imageViewToDraw);

        //setting the bitmap as a content view for the image
        reusableImageView.setImageBitmap(bitmap);


    }


    public void getFontSizeAndColor (){

        String tx = spinnerUse.getSelectedItem().toString();
        float fnt = Float.valueOf(tx);

        paint = new Paint();
        paint.setStrokeWidth(fnt);
        paint.setColor(Color.RED);


    }





    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.WHITE);
    }
    //
    public void moveRect(Canvas canvas)
    {
        //canvas.translate(endx-startx, endy-starty);
        reusableImageView.setTranslationX(endx - startx);
        reusableImageView.setTranslationY(endy - starty);
        reusableImageView.setColorFilter(Color.GREEN);

    }

    public void drawLine(int keyCode, Canvas canvas)
    {
        //textView.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,1000,1000,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;


    }
    public void drawLineImage(Canvas canvas)
    {
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }
    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes

    public void buttonUpClick(View v){

        String text = spinnerUse.getSelectedItem().toString();
        float font = Float.valueOf(text);
        paint.setStrokeWidth(font);

        String selectColor = spinnerColor.getSelectedItem().toString();


        int color =  Color.parseColor(selectColor);
        paint.setColor(color);


        ImageButton ib = (ImageButton) findViewById(R.id.imageButtonUp);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy-5;
               drawLineImage(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

            }
        });

    }

    public void buttonDownClick(View v){

        String text = spinnerUse.getSelectedItem().toString();
        float font = Float.valueOf(text);
        paint.setStrokeWidth(font);

        String selectColor = spinnerColor.getSelectedItem().toString();


        int color =  Color.parseColor(selectColor);
        paint.setColor(color);

        ImageButton ib = (ImageButton) findViewById(R.id.imageButtonDown);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy+5;
                drawLineImage(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

            }
        });

    }

    public void buttonRightClick(View v){

        String text = spinnerUse.getSelectedItem().toString();
        float font = Float.valueOf(text);
        paint.setStrokeWidth(font);

        String selectColor = spinnerColor.getSelectedItem().toString();


        int color =  Color.parseColor(selectColor);
        paint.setColor(color);

        ImageButton ib = (ImageButton) findViewById(R.id.imageButtonRight);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+5;
                drawLineImage(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

            }
        });

    }

    public void buttonLeftClick(View v){

        String text = spinnerUse.getSelectedItem().toString();
        float font = Float.valueOf(text);
        paint.setStrokeWidth(font);

        String selectColor = spinnerColor.getSelectedItem().toString();


        int color =  Color.parseColor(selectColor);
        paint.setColor(color);

        ImageButton ib = (ImageButton) findViewById(R.id.imageButtonLeft);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-5;
                drawLineImage(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

            }
        });

    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        String text = spinnerUse.getSelectedItem().toString();
        float font = Float.valueOf(text);
            paint.setStrokeWidth(font);

        String selectColor = spinnerColor.getSelectedItem().toString();


        int color =  Color.parseColor(selectColor);
        paint.setColor(color);

        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy+5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy-5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

        }
        return false;
    }

}
