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
import com.aylien.textapi.parameters.ClassifyParams;
import com.aylien.textapi.parameters.SummarizeParams;
import com.aylien.textapi.responses.Category;
import com.aylien.textapi.responses.Classifications;
import com.aylien.textapi.responses.Summarize;

import java.net.MalformedURLException;
import java.net.URL;


public class MainScreen extends AppCompatActivity {
    public EditText textbox;
    public String text;
    private static final String APPLICATION_ID = "43ce45d3";
    private static final String APPLICATION_KEY ="9b8d661297de0f55326ee0ef0bdc2531";
    public final static String SUMMARY = "com.capitalonecodingchallenge2016.easyread.SUMMARY";
    public final static String CONCEPT = "com.capitalonecodingchallenge2016.easyread.CONCEPT";
    public String message;
    public String concept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ImageView newsPaper = (ImageView) findViewById(R.id.ScreenImage); //resize images so no out of memory exception
        ImageView rightArrow = (ImageView) findViewById(R.id.Arrow);
        ImageView article = (ImageView) findViewById((R.id.Article));
        textbox = (EditText) findViewById(R.id.textBox);
        text = textbox.getText().toString();
        Toast.makeText(this,"What It Should Look like when running with an article", Toast.LENGTH_LONG).show();
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
        if (textbox.getText().toString().matches("")) { // If no URL is entered then display message
            Toast.makeText(this, "You did not enter a URL", Toast.LENGTH_SHORT).show();
            return;
        }
        //new callAPI().execute(); //calls for the API  UNCOMMENT WHEN WORKING
        Intent summaryIntent = new Intent(this, SummarizedPage.class); // makes new page for Summarized article
        //summaryIntent.putExtra(SUMMARY, message);   UNCOMMENT WHEN WORKING
        //summaryIntent.putExtra(CONCEPT,concept);   UNCOMMENT WHEN WORKING
        startActivity(summaryIntent);
    }

    public class callAPI extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                TextAPIClient client = new TextAPIClient(APPLICATION_ID, APPLICATION_KEY); //API call with Key and ID as free user
                URL url = new URL(text); // URL from the inputed Textbox
                SummarizeParams.Builder builder = SummarizeParams.newBuilder(); //Summarizer
                builder.setUrl(url);
                builder.setNumberOfSentences(3);
                Summarize summary = client.summarize(builder.build()); // builds the summary

                ClassifyParams.Builder builder1 = ClassifyParams.newBuilder(); //Classifier
                builder.setUrl(url);
                Classifications classifications = client.classify(builder1.build()); //makes the concepts

                message = "";
                concept = "";
                for (Category category: classifications.getCategories()) {
                    concept += category.getLabel() + " ";
                }
                for (String sentence : summary.getSentences()) {
                    message += sentence;
                }
                TextAPIClient.RateLimits rateLimits = client.getRateLimits(); // prints out #of calls per day in LogCat
                Log.i("Limit: ",String.valueOf(rateLimits.getLimit()));  // limited amount of calls because of free user
                Log.i("Remaining: ", String.valueOf(rateLimits.getRemaining()));
                Log.i("Reset: ", String.valueOf(rateLimits.getReset()));
            } catch (TextAPIException apiException) { // Cannot reach API call exception
                Log.i("Error",apiException.getMessage());
            } catch (MalformedURLException badWebURL) { // catch exception when an invalid URL is entered
                Log.i("Error", "Website does not exist");
            } catch (RuntimeException run) {
                Log.i("RunError", run.getMessage());
            }
            return null;
        }
    }

}
