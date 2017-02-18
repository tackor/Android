package com.example.tacker.myapplication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screenTitleOne;
    private TextView screenTitleTwo;
    private TextView screenTitleThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenTitleOne = (TextView) findViewById(R.id.main_text_01);
        Typeface iconMoonFont_01 = Typeface.createFromAsset(getAssets(), "fonts/IcoMoon-Free.ttf");
        screenTitleOne.setTypeface(iconMoonFont_01);

        screenTitleTwo = (TextView) findViewById(R.id.main_text_02);
        Typeface iconMoonFont_02 = Typeface.createFromAsset(getAssets(), "fonts/IcoMoon-Free.ttf");
        screenTitleTwo.setTypeface(iconMoonFont_02);

        screenTitleThree = (TextView) findViewById(R.id.main_text_03);
        Typeface iconMoonFont_03 = Typeface.createFromAsset(getAssets(), "fonts/icomoon.ttf");
        screenTitleThree.setTypeface(iconMoonFont_03);


    }
}
