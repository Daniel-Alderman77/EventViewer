package com.example.danielalderman.eventviewer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private String[] dates;
    private String[] images;
    private Activity context;

    CustomList(Activity context, String[] names, String[] dates, String[] images) {
        super(context, R.layout.list_view_layout, names);
        this.context = context;
        this.names = names;
        this.dates = dates;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);

        // TODO - Add Custom ImageView
        TextView imageView = (TextView) listViewItem.findViewById(R.id.imageView);

        textViewName.setText(names[position]);
        textViewDate.setText(dates[position]);
        imageView.setText(images[position]);

        return listViewItem;
    }
}
