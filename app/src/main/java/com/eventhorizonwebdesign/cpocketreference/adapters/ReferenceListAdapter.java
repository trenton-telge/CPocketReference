package com.eventhorizonwebdesign.cpocketreference.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.eventhorizonwebdesign.cpocketreference.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Trenton on 4/7/2017.
 */

public class ReferenceListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String[]>> listDataChild;
    public ReferenceListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String[]>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    private class ViewHolder {
        TextView partTextView;
        TextView argsTextView;
        TextView purposeTextView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        //final String childText = (String) getChild(groupPosition, childPosition);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.ref_list_item_child, null);
            holder.partTextView = (TextView) convertView.findViewById(R.id.part);
            holder.argsTextView = (TextView) convertView.findViewById(R.id.args);
            holder.purposeTextView = (TextView) convertView.findViewById(R.id.purpose);
            convertView.setTag(holder);
            convertView.setClickable(false);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String[] childData = this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
        holder.partTextView.setText(childData[0]);
        holder.argsTextView.setText(childData[1]);
        holder.purposeTextView.setText(childData[2]);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.ref_list_item_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}