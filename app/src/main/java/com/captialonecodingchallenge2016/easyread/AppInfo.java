package com.captialonecodingchallenge2016.easyread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AppInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
    }

    public void go_to_Home(View view) {
        Intent homeIntent = new Intent(this, MainScreen.class);
        startActivity(homeIntent);
    }

    public void go_to_AboutMe(View view) {
        Intent aboutMeIntent = new Intent(this,AboutMe.class);
        startActivity(aboutMeIntent);
    }
}
