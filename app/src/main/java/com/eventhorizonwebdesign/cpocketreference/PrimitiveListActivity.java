package com.eventhorizonwebdesign.cpocketreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.eventhorizonwebdesign.cpocketreference.adapters.PrimitiveListAdapter;

public class PrimitiveListActivity extends AppCompatActivity {

    ListView primitiveListView;
    ListAdapter primitiveListAdapter;
    String[] primitiveTypesList;
    String[] primitiveTagsList;
    String[] primitiveBoundsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primitive_list);

        primitiveListView = (ListView)findViewById(R.id.primitive_list);
        prepareListData();
        primitiveListAdapter = new PrimitiveListAdapter(this, primitiveTypesList, primitiveTagsList, primitiveBoundsList);
        primitiveListView.setAdapter(primitiveListAdapter);
    }

    private void prepareListData(){
        primitiveTypesList = getResources().getStringArray(R.array.primitive_types);
        primitiveTagsList = getResources().getStringArray(R.array.primitive_tags);
        primitiveBoundsList = getResources().getStringArray(R.array.primitive_bounds);
    }
}
