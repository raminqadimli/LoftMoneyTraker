package com.example.user.loftmoneytraker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Admin on 27-Apr-15.
 */
public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ViewHolder> {

    private final List<Transaction> transactions;

    public TransactionsAdapter(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Transaction product = transactions.get(position);
        holder.txvName.setText(product.getComment());
        holder.txvSumm.setText(Integer.toString(product.getSum()));
        holder.txvDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(product.getCreatedDate()));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txvName;
        private TextView txvDate;
        private TextView txvSumm;

        public ViewHolder(View v) {
            super(v);
            txvName = (TextView) v.findViewById(R.id.name_id);
            txvDate = (TextView) v.findViewById(R.id.date_id);
            txvSumm = (TextView) v.findViewById(R.id.sum_id);
        }
    }
}

