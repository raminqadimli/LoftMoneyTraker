package com.example.user.loftmoneytraker;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Admin on 28-Apr-15.
 */
public class TransactionsFragment extends Fragment {

    private OnListTransactionListener mListener;

    public interface OnListTransactionListener {
        public void onItemSelected(String description);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_transaction, container, false);

        ArrayList<Transaction> transactions = getTransactionList(30);
        RecyclerView list = (RecyclerView) view.findViewById(R.id.list_view_id);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(layoutManager);

        TransactionsAdapter adapter = new TransactionsAdapter(transactions);
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToRecyclerView(list);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnListTransactionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement the interface TransactionsFragment.OnListTransactionListener");
        }
    }

    private ArrayList<Transaction> getTransactionList(int size) {
        ArrayList<Transaction> p = new ArrayList<Transaction>();
        for (int i = 1; i <= size; i++) {
            p.add(new Transaction("Transaction" + i, new SimpleDateFormat("dd-MM-yyyy").format(new Date()), i * 1000, getResources().getString(R.string.descriptionTransaction)));
        }

        return p;
    }

    private void sendDetailTransaction(String description) {
        mListener.onItemSelected(description);
    }
}
