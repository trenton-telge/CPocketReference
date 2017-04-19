package com.eventhorizonwebdesign.cpocketreference;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        WebView tutorialView = (WebView)findViewById(R.id.tutorial_view);
        Intent intent = getIntent();
        String t = intent.getStringExtra("t");
        switch(t){
            case "Hello World":
                tutorialView.loadUrl("file:///android_asset/hello_world.html");
                break;
            case "Writing Statements":
                tutorialView.loadUrl("file:///android_asset/statements.html");
                break;
            case "Writing Expressions":
                break;
            case "Conditionals":
                break;
            case "For Loop":
                tutorialView.loadUrl("file:///android_asset/for_loop.html");
                break;
            case "While Loop":
                break;
            case "Do-While Loop":
                break;
            case "Functions":
                break;
            case "Encapsulation":
                break;
            default:
                //TODO make this not fail silently
                break;
        }
    }
}
