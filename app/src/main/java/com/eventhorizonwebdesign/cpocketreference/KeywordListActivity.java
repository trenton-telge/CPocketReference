package com.eventhorizonwebdesign.cpocketreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.eventhorizonwebdesign.cpocketreference.adapters.KeywordListAdapter;

public class KeywordListActivity extends AppCompatActivity {

    ListView keywordListView;
    ListAdapter keywordListAdapter;
    String[][] content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyword_list);

        keywordListView = (ListView) findViewById(R.id.ascii_table);
        prepareListData();
        keywordListAdapter = new KeywordListAdapter(this, content);
        keywordListView.setAdapter(keywordListAdapter);
        keywordListView.addHeaderView(getLayoutInflater().inflate(R.layout.ascii_list_item_header, keywordListView, false));
    }

    private void prepareListData() {
        //TODO fill content
        content[0] = getResources().getStringArray(R.array.keyword_names);
        content[1] = getResources().getStringArray(R.array.keyword_defs);
    }
}
