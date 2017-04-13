package com.eventhorizonwebdesign.cpocketreference;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.eventhorizonwebdesign.cpocketreference.adapters.ExpandableListAdapter;
import com.eventhorizonwebdesign.cpocketreference.adapters.ReferenceListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReferenceListActivity extends AppCompatActivity {

    ReferenceListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String[]>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_list);
        expListView =(ExpandableListView) findViewById(R.id.ref_list);
        Intent intent = getIntent();
        String t = intent.getStringExtra("t");
        prepareListData(t);
        listAdapter = new ReferenceListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        final Context c = this.getApplicationContext();

    }

    void prepareListData(String t){
        listDataHeader = new ArrayList<>();
        // This is the array that will hold the Strings for all the header titles.
        listDataChild = new HashMap<>();
        // This is the HashMap that will link header strings to their respective list of children
        switch (t) {
            case "iostream":
                listDataHeader.add("Narrow Characters");
                listDataHeader.add("Wide Characters");

                List<String[]> narrow = new ArrayList<>();
                narrow.add(new String[]{"cin", "", "Standard input stream"});
                narrow.add(new String[]{"cout", "", "Standard output stream"});
                narrow.add(new String[]{"cerr", "", "Standard error output stream"});
                narrow.add(new String[]{"clog", "", "Standard logging output stream"});

                List<String[]> wide = new ArrayList<>();
                wide.add(new String[]{"wcin", "", "Standard input stream (wide)"});
                wide.add(new String[]{"wcout", "", "Standard output stream (wide)"});
                wide.add(new String[]{"wcerr", "", "Standard error output stream (wide)"});
                wide.add(new String[]{"wclog", "", "Standard logging output stream (wide)"});

                listDataChild.put(listDataHeader.get(0), narrow);
                listDataChild.put(listDataHeader.get(1), wide);
                break;
        }
    }
}
