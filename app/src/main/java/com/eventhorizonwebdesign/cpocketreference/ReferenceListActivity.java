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

                List<String[]> narrowio = new ArrayList<>();
                narrowio.add(new String[]{"cin", "", "Standard input stream"});
                narrowio.add(new String[]{"cout", "", "Standard output stream"});
                narrowio.add(new String[]{"cerr", "", "Standard error output stream"});
                narrowio.add(new String[]{"clog", "", "Standard logging output stream"});

                List<String[]> wideio = new ArrayList<>();
                wideio.add(new String[]{"wcin", "", "Standard input stream (wide)"});
                wideio.add(new String[]{"wcout", "", "Standard output stream (wide)"});
                wideio.add(new String[]{"wcerr", "", "Standard error output stream (wide)"});
                wideio.add(new String[]{"wclog", "", "Standard logging output stream (wide)"});

                listDataChild.put(listDataHeader.get(0), narrowio);
                listDataChild.put(listDataHeader.get(1), wideio);
                break;
            case "fstream":
                listDataHeader.add("Class Templates");
                listDataHeader.add("Narrow Characters");
                listDataHeader.add("Wide Characters");

                List<String[]> templates = new ArrayList<>();
                templates.add(new String[]{"basic_ifstream", "", "Input file stream template"});
                templates.add(new String[]{"basic_ofstream", "", "Output file stream template"});
                templates.add(new String[]{"basic_fstream", "", "File stream template"});
                templates.add(new String[]{"basic_filebuf", "", "File stream buffer template"});

                List<String[]> narrowf = new ArrayList<>();
                narrowf.add(new String[]{"ifstream", "", "Input file stream"});
                narrowf.add(new String[]{"ofstream", "", "Output file stream"});
                narrowf.add(new String[]{"fstream", "", "Input/Output file stream"});
                narrowf.add(new String[]{"filebuf", "", "File stream buffer"});

                List<String[]> widef = new ArrayList<>();
                widef.add(new String[]{"wifstream", "", "Input file stream (wide)"});
                widef.add(new String[]{"wofstream", "", "Output file stream (wide)"});
                widef.add(new String[]{"wfstream", "", "Input/Output file stream (wide)"});
                widef.add(new String[]{"wfilebuf", "", "File stream buffer (wide)"});

                listDataChild.put(listDataHeader.get(0), templates);
                listDataChild.put(listDataHeader.get(1), narrowf);
                listDataChild.put(listDataHeader.get(2), widef);
                break;
            case "iomanip":
                listDataHeader.add("IO Manipulators");

                List<String[]> manipulators = new ArrayList<>();
                manipulators.add(new String[]{"setiosflags", "[Mask]", "Set specified format flags"});
                manipulators.add(new String[]{"resetiosflags", "[Mask]", "Reset specified format flags"});
                manipulators.add(new String[]{"setbase", "[Base]", "Set basefield flag"});
                manipulators.add(new String[]{"setfill", "[char]", "Set fill character"});
                manipulators.add(new String[]{"setprecision", "[int]", "Set decimal precision"});
                manipulators.add(new String[]{"setw", "[int]", "Set field width"});
                manipulators.add(new String[]{"get_money", "[float || double || long double]", "Gets monetary value to argument"});
                manipulators.add(new String[]{"put_money", "[long double]", "Inserts monetary representation of argument"});
                manipulators.add(new String[]{"get_time", "[struct tm][string]", "Gets time value to struct argument"});
                manipulators.add(new String[]{"put_time", "[struct tm][string]", "Inserts time representation of struct argument"});

                listDataChild.put(listDataHeader.get(0), manipulators);
                break;
            default:

                break;
        }
    }
}
