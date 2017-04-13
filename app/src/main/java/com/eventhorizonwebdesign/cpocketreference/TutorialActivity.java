package com.eventhorizonwebdesign.cpocketreference;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        TextView tutorialLoaderView = (TextView) findViewById(R.id.tutorial_text);
        Intent intent = getIntent();
        String t = intent.getStringExtra("t");
        String programCode;
        switch(t){
            case "Hello World":
                try {
                    Resources res = getResources();
                    InputStream in_s = res.openRawResource(R.raw.hello_world);
                    BufferedReader b = new BufferedReader(new InputStreamReader(in_s, "UTF-8"));
                    StringBuilder stringBuffer = new StringBuilder();
                    String line;
                    while((line =b.readLine())!=null){
                        stringBuffer.append(line).append("\n");
                    }
                    programCode = stringBuffer.toString();
                } catch (Exception e) {
                    programCode = "";
                    e.printStackTrace();
                }
                //TODO this is not what we will use in the final program (replace for PROD)
                tutorialLoaderView.setText(Html.fromHtml(programCode));
                break;
            default:
                break;
        }
    }
}
