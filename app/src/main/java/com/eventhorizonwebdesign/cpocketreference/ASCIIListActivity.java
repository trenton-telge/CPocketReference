package com.eventhorizonwebdesign.cpocketreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.eventhorizonwebdesign.cpocketreference.adapters.ASCIIListAdapter;

public class ASCIIListActivity extends AppCompatActivity {

    ListView asciiListView;
    ListAdapter asciiListAdapter;
    String[] decimalValuesList = new String[128];
    String[] charValuesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascii_list);

        asciiListView = (ListView) findViewById(R.id.ascii_table);
        prepareListData();
        asciiListAdapter = new ASCIIListAdapter(this, decimalValuesList, charValuesList);
        asciiListView.setAdapter(asciiListAdapter);
        asciiListView.addHeaderView(getLayoutInflater().inflate(R.layout.ascii_list_item_header, asciiListView, false));
    }

    private void prepareListData(){
        for (int c = 0; c <= 127; c++){
            decimalValuesList[c] = Integer.toString(c);
        }
        charValuesList = getResources().getStringArray(R.array.ascii_values);
    }
}
