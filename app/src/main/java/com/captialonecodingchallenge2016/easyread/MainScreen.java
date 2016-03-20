package com.captialonecodingchallenge2016.easyread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ImageView newsPaper = (ImageView) findViewById(R.id.ScreenImage); //resize images so no out of memory exception
        ImageView rightArrow = (ImageView) findViewById(R.id.Arrow);
        ImageView article = (ImageView) findViewById((R.id.Article));
    }

    public void go_to_AppInfo(View view) {
        Intent intent = new Intent(this, AppInfo.class);
        startActivity(intent);
    }

    public void go_to_AboutMe(View view) {
        Intent aboutMeIntent = new Intent(this, AboutMe.class);
        startActivity(aboutMeIntent);
    }

}
