package com.eventhorizonwebdesign.cpocketreference.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eventhorizonwebdesign.cpocketreference.R;

/**
 * Created by Trenton on 4/3/2017.
 */

public class PrimitiveListAdapter extends BaseAdapter {
    private String[] types;
    private String[] tags;
    private String[] bounds;
    private static LayoutInflater inflater = null;

    public PrimitiveListAdapter(Context mainActivity, String[] typesList, String[] tagsList, String[] boundsList) {
        types = typesList;
        tags = tagsList;
        bounds = boundsList;
        inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return types.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView typeTextView;
        TextView tagsTextView;
        TextView boundsTextView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.primitive_list_item_child, null);
            holder.typeTextView = (TextView) convertView.findViewById(R.id.keyword);
            holder.tagsTextView = (TextView) convertView.findViewById(R.id.tags);
            holder.boundsTextView = (TextView) convertView.findViewById(R.id.range);
            convertView.setTag(holder);
            convertView.setClickable(false);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.typeTextView.setText(types[position]);
        holder.tagsTextView.setText(tags[position]);
        holder.boundsTextView.setText(bounds[position]);
        return convertView;
    }
}