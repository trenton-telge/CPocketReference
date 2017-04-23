package com.eventhorizonwebdesign.cpocketreference;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import com.eventhorizonwebdesign.cpocketreference.util.UnexpectedInputException;

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
                tutorialView.loadUrl("file:///android_asset/expressions.html");
                break;
            case "Conditionals":
                tutorialView.loadUrl("file:///android_asset/conditionals.html");
                break;
            case "For Loop":
                tutorialView.loadUrl("file:///android_asset/for_loop.html");
                break;
            case "While Loop":
                tutorialView.loadUrl("file:///android_asset/while_loop.html");
                break;
            case "Do-While Loop":
                tutorialView.loadUrl("file:///android_asset/do_while_loop.html");
                break;
            case "Functions":
                tutorialView.loadUrl("file:///android_asset/functions.html");
                break;
            case "Encapsulation":
                break;
            default:
                try{
                    throw new UnexpectedInputException();
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }
}
