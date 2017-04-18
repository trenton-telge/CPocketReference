package com.eventhorizonwebdesign.cpocketreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.eventhorizonwebdesign.cpocketreference.adapters.EscapeListAdapter;

public class EscapeListActivity extends AppCompatActivity {

    ListView escapeListView;
    ListAdapter escapeListAdapter;
    String[] escapeCharsList;
    String[] escapeEquivalentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escapes_list);

        escapeListView = (ListView) findViewById(R.id.escape_list);
        prepareListData();
        escapeListAdapter = new EscapeListAdapter(this, escapeCharsList, escapeEquivalentsList);
        escapeListView.setAdapter(escapeListAdapter);
    }

    private void prepareListData(){
        escapeCharsList = getResources().getStringArray(R.array.escape_chars);
        escapeEquivalentsList = getResources().getStringArray(R.array.escape_equivalents);
    }
}
