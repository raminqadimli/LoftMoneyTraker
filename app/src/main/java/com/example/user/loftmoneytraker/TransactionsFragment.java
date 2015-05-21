package com.example.user.loftmoneytraker;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.melnykov.fab.FloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Admin on 28-Apr-15.
 */
@EFragment(R.layout.fragment_list_transaction)
public class TransactionsFragment extends Fragment {

    private OnListTransactionListener mListener;

    @ViewById(R.id.list_view_id)
    RecyclerView list;

    @ViewById(R.id.fab)
    FloatingActionButton fab;

    public interface OnListTransactionListener {
        public void onItemSelected(String description);
    }

    @AfterViews
    void init() {
        ArrayList<Transaction> transactions = getTransactionList(30);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(layoutManager);

        TransactionsAdapter adapter = new TransactionsAdapter(transactions);
        list.setAdapter(adapter);

        fab.attachToRecyclerView(list);
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
