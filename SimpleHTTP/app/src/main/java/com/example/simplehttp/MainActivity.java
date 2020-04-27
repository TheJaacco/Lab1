package com.example.simplehttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.goBTN).setOnClickListener(this);
        findViewById(R.id.editTxt);
        StrictMode.ThreadPolicy policy =  new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy);

        loadFromInterwebz("https://www.oamk.fi");
    }

    protected void loadFromInterwebz(String urlString){
        try {
            URL url =new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String htmlText = Utilities.fromStream(in);
            TextView textView = findViewById(R.id.textView);
            textView.setText(htmlText);

        }
        catch (Exception e) {e.printStackTrace();
    }



    }

    @Override
    public void onClick(View v) {
        findViewById(R.id.goBTN);

    }
}
