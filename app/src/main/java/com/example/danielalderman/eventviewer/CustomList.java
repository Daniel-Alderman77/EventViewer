package com.example.danielalderman.eventviewer;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private String[] dates;
    private String[] images;
    private String[] webViews;

    private Activity context;

    CustomList(Activity context, String[] names, String[] dates, String[] images, String[] webViews) {
        super(context, R.layout.list_view_layout, names);
        this.context = context;
        this.names = names;
        this.dates = dates;
        this.images = images;
        this.webViews = webViews;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        final View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.imageView);

        textViewName.setText(names[position]);
        textViewDate.setText(dates[position]);

        Picasso.with(context).load(images[position]).into(imageView);

        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View list) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("URL", webViews[position]);
                context.startActivity(intent);
            }
        });

        return listViewItem;
    }
}
