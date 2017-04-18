package com.eventhorizonwebdesign.cpocketreference.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eventhorizonwebdesign.cpocketreference.R;

/**
 * Created by Trenton on 4/13/2017.
 */

public class KeywordListAdapter extends BaseAdapter {
    private String[][] content;
    private static LayoutInflater inflater=null;
    public KeywordListAdapter(Context mainActivity, String[][] content) {
        this.content = content;
        inflater = (LayoutInflater)mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return content[0].length;
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
        TextView keyword;
        TextView desc;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.keyword_list_item_child, null);
            holder.keyword = (TextView) convertView.findViewById(R.id.keyword);
            holder.desc = (TextView) convertView.findViewById(R.id.description);
            convertView.setTag(holder);
            convertView.setClickable(false);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.keyword.setText(content[0][position]);
        holder.desc.setText(content[1][position]);
        return convertView;
    }
}
