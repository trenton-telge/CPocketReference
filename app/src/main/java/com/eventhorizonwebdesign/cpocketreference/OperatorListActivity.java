package com.eventhorizonwebdesign.cpocketreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.eventhorizonwebdesign.cpocketreference.adapters.OperatorListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OperatorListActivity extends AppCompatActivity {

    ExpandableListView operatorListView;
    ExpandableListAdapter operatorListAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String[]>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator_list);

        operatorListView = (ExpandableListView) findViewById(R.id.operators_list);
        prepareListData();
        operatorListAdapter = new OperatorListAdapter(this, listDataHeader, listDataChild);
        operatorListView.setAdapter(operatorListAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        // This is the array that will hold the Strings for all the header titles.
        listDataChild = new HashMap<>();
        // This is the HashMap that will link header strings to their respective list of children

        // Adding header data
        listDataHeader.add("Arithmetic");
        listDataHeader.add("Relational");
        listDataHeader.add("Logical");
        listDataHeader.add("Bitwise");
        listDataHeader.add("Assignment");
        listDataHeader.add("Miscellaneous");

        List<String[]> arithmetic = new ArrayList<>();
        arithmetic.add(new String[]{"+", "Adds two operands"});
        arithmetic.add(new String[]{"-", "Subtracts second operand from the first"});
        arithmetic.add(new String[]{"*", "Multiplies two operands"});
        arithmetic.add(new String[]{"/", "Divides first operand by second"});
        arithmetic.add(new String[]{"%", "Calculates remainder of integer division (Modulus)"});
        arithmetic.add(new String[]{"++", "Increments integer value by one"});
        arithmetic.add(new String[]{"--", "Decrements integer value by one"});

        List<String[]> relational = new ArrayList<>();
        relational.add(new String[]{"==", "Checks equality of operands"});
        relational.add(new String[]{"!=", "Checks inequality of two operands"});
        relational.add(new String[]{">", "Checks if first operand is greater than second"});
        relational.add(new String[]{"<", "Checks if first operand is less than second"});
        relational.add(new String[]{">=", "Checks if first operand is greater than or equal to second"});
        relational.add(new String[]{"<=", "Checks if first operand is less than or equal to second"});

        List<String[]> logical = new ArrayList<>();
        logical.add(new String[]{"&&", "Logical AND"});
        logical.add(new String[]{"||", "Logical OR"});
        logical.add(new String[]{"!", "Logical NOT"});

        List<String[]> bitwise = new ArrayList<>();
        bitwise.add(new String[]{"&", "Bitwise AND"});
        bitwise.add(new String[]{"|", "Bitwise OR"});
        bitwise.add(new String[]{"^", "Bitwise XOR"});
        bitwise.add(new String[]{"~", "Binary ones complement"});
        bitwise.add(new String[]{"<<", "Binary left shift"});
        bitwise.add(new String[]{">>", "Binary right shift"});

        List<String[]> assignment = new ArrayList<>();
        assignment.add(new String[]{"=", "Assigns right operand value to left operand"});
        assignment.add(new String[]{"+=", "Adds right operand to left"});
        assignment.add(new String[]{"-=", "Subtracts right operand from left"});
        assignment.add(new String[]{"*=", "Multiplies left operand by right"});
        assignment.add(new String[]{"/=", "Divides left operand by right"});
        assignment.add(new String[]{"%=", "Assigns modulus of operands to left operand"});
        assignment.add(new String[]{"<<=", "Left shift and assignment operator"});
        assignment.add(new String[]{">>=", "Right shift and assignment operator"});
        assignment.add(new String[]{"&=", "Bitwise AND and assignment operator"});
        assignment.add(new String[]{"^=", "Bitwise exclusive OR and assignemnt operator"});
        assignment.add(new String[]{"|=", "Bitwise inclusive OR and assignment operator"});

        List<String[]> miscellaneous = new ArrayList<>();
        miscellaneous.add(new String[]{"sizeof", "Returns size of variable in memory"});
        miscellaneous.add(new String[]{"[Condition] ? [R1] : [R2]", "If condition, return R1, if not, return R2"});
        miscellaneous.add(new String[]{",", "Chains a sequence of operations"});
        miscellaneous.add(new String[]{".", "Allows references to child members"});
        miscellaneous.add(new String[]{"([type])", "C-style cast to the type in parenthesis"});
        miscellaneous.add(new String[]{"&[variable]", "Points to the actual address of a variable"});
        miscellaneous.add(new String[]{"*[variable]", "Points to the value of a variable"});

        listDataChild.put(listDataHeader.get(0), arithmetic);
        listDataChild.put(listDataHeader.get(1), relational);
        listDataChild.put(listDataHeader.get(2), logical);
        listDataChild.put(listDataHeader.get(3), bitwise);
        listDataChild.put(listDataHeader.get(4), assignment);
        listDataChild.put(listDataHeader.get(5), miscellaneous);
    }
}
