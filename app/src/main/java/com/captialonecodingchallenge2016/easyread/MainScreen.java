package com.captialonecodingchallenge2016.easyread;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.TextAPIException;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.parameters.SummarizeParams;
import com.aylien.textapi.responses.Sentiment;
import com.aylien.textapi.responses.Summarize;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainScreen extends AppCompatActivity {
    private EditText textbox;
    private static final String APPLICATION_ID = "43ce45d3";
    private static final String APPLICATION_KEY ="9b8d661297de0f55326ee0ef0bdc2531";
    public final static String SUMMARY = "com.capitalonecodingchallenge2016.easyread.SUMMARY";
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ImageView newsPaper = (ImageView) findViewById(R.id.ScreenImage); //resize images so no out of memory exception
        ImageView rightArrow = (ImageView) findViewById(R.id.Arrow);
        ImageView article = (ImageView) findViewById((R.id.Article));
        textbox = (EditText) findViewById(R.id.textBox);
    }

    public void go_to_AppInfo(View view) {
        Intent intent = new Intent(this, AppInfo.class);
        startActivity(intent);
    }

    public void go_to_AboutMe(View view) {
        Intent aboutMeIntent = new Intent(this, AboutMe.class);
        startActivity(aboutMeIntent);
    }

    public void submit(View view) throws Exception  {
        if (textbox.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a URL", Toast.LENGTH_SHORT).show();
            return;
        }
        new callAPI().execute();
        Intent summaryIntent = new Intent(this, SummarizedPage.class);
        summaryIntent.putExtra(SUMMARY, message);
        startActivity(summaryIntent);
    }

    public class callAPI extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                TextAPIClient client = new TextAPIClient(APPLICATION_ID, APPLICATION_KEY);
//              url = new URL(textbox.getText().toString());
                URL url = new URL("http://techcrunch.com/2015/04/06/john-oliver-just-changed-the-surveillance-reform-debate");
                SummarizeParams.Builder builder = SummarizeParams.newBuilder();
                builder.setUrl(url);
                builder.setNumberOfSentences(3);
                Summarize summary = client.summarize(builder.build());
                message = "";
                for (String sentence : summary.getSentences()) {
                    message += sentence;
                }
                TextAPIClient.RateLimits rateLimits = client.getRateLimits();
                Log.i("Limit: ",String.valueOf(rateLimits.getLimit()));
                Log.i("Remaining: ", String.valueOf(rateLimits.getRemaining()));
                Log.i("Reset: ", String.valueOf(rateLimits.getReset()));
            } catch (TextAPIException apiException) {
                Log.i("Error",apiException.getMessage());
            } catch (MalformedURLException badWebURL) {
                Log.i("Error", "Website does not exist");
            } catch (RuntimeException run) {
                Log.i("RunError", run.getMessage());
            }
            return null;
        }
    }

}
