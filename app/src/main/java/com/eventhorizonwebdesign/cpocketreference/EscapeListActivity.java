package com.eventhorizonwebdesign.cpocketreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.eventhorizonwebdesign.cpocketreference.adapters.EscapeListAdapter;

public class EscapeListActivity extends AppCompatActivity {

    ListView operatorsListView;
    ListAdapter operatorsListAdapter;
    String[] escapeCharsList;
    String[] escapeEquivalentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escapes_list);

        operatorsListView = (ListView) findViewById(R.id.ascii_table);
        prepareListData();
        operatorsListAdapter = new EscapeListAdapter(this, escapeCharsList, escapeEquivalentsList);
        operatorsListView.setAdapter(operatorsListAdapter);
    }

    private void prepareListData(){
        escapeCharsList = getResources().getStringArray(R.array.escape_chars);
        escapeEquivalentsList = getResources().getStringArray(R.array.escape_equivalents);
    }
}
