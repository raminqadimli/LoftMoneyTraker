package com.example.user.loftmoneytraker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 03-May-15.
 */
public class CategoryAdapter extends ArrayAdapter<Category> {

    private final Context context;
    private final ArrayList<Category> categories;

    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        super(context, 0, categories);
        this.context = context;
        this.categories = categories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category category = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_list_item, parent, false);
        }

        TextView txtView = (TextView) convertView.findViewById(R.id.category_name);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.category_image);
        txtView.setText(category.getName());
        imgView.setImageResource(category.getImage());
        if (position % 2 == 0) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.even_list_item));
        } else {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.odd_list_item));
        }
        return convertView;
    }
}
