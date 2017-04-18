package com.eventhorizonwebdesign.cpocketreference.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eventhorizonwebdesign.cpocketreference.R;

/**
 * Created by Trenton on 4/18/2017.
 */

public class EscapeListAdapter extends BaseAdapter {
    private String [] escapeCharacters;
    private String [] escapeEquivalents;
    private static LayoutInflater inflater=null;
    public EscapeListAdapter(Context mainActivity, String[] resultsList, String[] characterList) {
        escapeCharacters = resultsList;
        escapeEquivalents = characterList;
        inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return escapeCharacters.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder
    {
        TextView decimalValueView;
        TextView charTextView;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.escape_list_item_child, null);
            holder.decimalValueView = (TextView) convertView.findViewById(R.id.escape_char);
            holder.charTextView = (TextView) convertView.findViewById(R.id.escape_equiv);
            convertView.setTag(holder);
            convertView.setClickable(false);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.decimalValueView.setText(escapeCharacters[position]);
        holder.charTextView.setText(escapeEquivalents[position]);
        return convertView;
    }
}
