package com.example.danielalderman.eventviewer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomList extends ArrayAdapter<String> {
    private String[] ids;
    private Activity context;

    CustomList(Activity context, String[] ids) {
        super(context, R.layout.list_view_layout, ids);
        this.context = context;
        this.ids = ids;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);

        textViewId.setText(ids[position]);

        return listViewItem;
    }
}
