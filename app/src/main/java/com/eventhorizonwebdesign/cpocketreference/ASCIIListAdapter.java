package com.eventhorizonwebdesign.cpocketreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class ASCIIListAdapter extends BaseAdapter{
    String [] result;
    Context context;
    String [] character;
    private static LayoutInflater inflater=null;
    public ASCIIListAdapter(Context mainActivity, String[] prgmNameList, String[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        character =prgmImages;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    private class Holder
    {
        TextView decimalValueView;
        TextView charTextView;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.ascii_list_item_child, null);
        holder.decimalValueView =(TextView) rowView.findViewById(R.id.textView1);
        holder.charTextView =(TextView) rowView.findViewById(R.id.textView2);
        holder.decimalValueView.setText(result[position]);
        holder.charTextView.setText(character[position]);
        rowView.setClickable(false);
        return rowView;
    }

} 