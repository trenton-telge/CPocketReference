package com.eventhorizonwebdesign.cpocketreference.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eventhorizonwebdesign.cpocketreference.R;

public class ASCIIListAdapter extends BaseAdapter{
    private String [] results;
    private String [] characters;
    private static LayoutInflater inflater=null;
    public ASCIIListAdapter(Context mainActivity, String[] resultsList, String[] characterList) {
        results = resultsList;
        characters = characterList;
        inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return results.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class Holder
    {
        TextView decimalValueView;
        TextView charTextView;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ascii_list_item_child, null);
            holder.decimalValueView = (TextView) convertView.findViewById(R.id.textView1);
            holder.charTextView = (TextView) convertView.findViewById(R.id.textView2);
            holder.decimalValueView.setText(results[position]);
            holder.charTextView.setText(characters[position]);
            convertView.setClickable(false);
        }
        return convertView;
    }

} 