package com.captialonecodingchallenge2016.easyread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SummarizedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summarized_page);
        Intent intent = getIntent();
        String summary = intent.getStringExtra(MainScreen.SUMMARY);
        String concepts = intent.getStringExtra(MainScreen.CONCEPT);
        TextView summaryText = (TextView) findViewById(R.id.summary);
        TextView conceptText = (TextView) findViewById(R.id.concept);
        summaryText.setText(summary);
        conceptText.setText(concepts);
    }
}
