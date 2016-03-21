package com.captialonecodingchallenge2016.easyread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SummarizedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summarized_page);
        Intent intent = getIntent();
        Toast.makeText(this, "Ran with http://techcrunch.com/2015/04/06/john-oliver-just-changed-the-surveillance-reform-debate", Toast.LENGTH_LONG).show();
        //String summary = intent.getStringExtra(MainScreen.SUMMARY); UNCOMMENT WHEN WORKING
        //String concepts = intent.getStringExtra(MainScreen.CONCEPT); UNCOMMMET WHEN WORKING
        TextView summaryText = (TextView) findViewById(R.id.summary);
        TextView conceptText = (TextView) findViewById(R.id.concept);
        //summaryText.setText(summary); UNCOMMENT WHEN WORKING
        //conceptText.setText(concepts); UNCOMMENT WHEN WORKING
    }

    public void back(View view) { // returns back to home screen
        this.finish();
    }
}
