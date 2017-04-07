package com.eventhorizonwebdesign.cpocketreference;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.eventhorizonwebdesign.j420lighter.J420Lighter;

import java.io.InputStream;


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
        String programCode = "";
        switch(t){
            case "Hello World":
                try {
                    Resources res = getResources();
                    InputStream in_s = res.openRawResource(R.raw.hello_world);
                    byte[] b = new byte[in_s.available()];
                    in_s.read(b);
                    programCode = new String(b);
                } catch (Exception e) {
                    programCode = "";
                    e.printStackTrace();
                }
                programCode = new J420Lighter().highlight(programCode);
                tutorialLoaderView.loadData(programCode, "text/html; charset=UTF-8", null);
                break;
            default:
                break;
        }
    }
}
