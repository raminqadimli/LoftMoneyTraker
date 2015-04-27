package com.example.user.loftmoneytraker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 27-Apr-15.
 */
public class ProductAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.txvName = (TextView) convertView.findViewById(R.id.name_id);
            holder.txvDate = (TextView) convertView.findViewById(R.id.date_id);
            holder.txvSumm = (TextView) convertView.findViewById(R.id.sum_id);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txvName.setText(product.getName());
        holder.txvDate.setText(product.getCreatedDate());
        holder.txvSumm.setText(Integer.toString(product.getSum()));
        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.parseColor("#EFEFEF"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#CAFFFF"));
        }

        return convertView;
    }

    static class ViewHolder {
        public TextView txvName;
        public TextView txvDate;
        public TextView txvSumm;
    }
}

