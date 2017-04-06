package com.eventhorizonwebdesign.cpocketreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        WebView tutorialLoaderView = (WebView) findViewById(R.id.tutorial_webview);
        tutorialLoaderView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String t = intent.getStringExtra("t");
        //TODO switch on t for which HTML file to show.
    }
}
