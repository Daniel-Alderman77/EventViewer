package com.example.danielalderman.eventviewer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private String[] dates;
    private Activity context;

    CustomList(Activity context, String[] names, String[] dates) {
        super(context, R.layout.list_view_layout, names);
        this.context = context;
        this.names = names;
        this.dates = dates;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);

        textViewName.setText(names[position]);
        textViewDate.setText(dates[position]);

        return listViewItem;
    }
}
