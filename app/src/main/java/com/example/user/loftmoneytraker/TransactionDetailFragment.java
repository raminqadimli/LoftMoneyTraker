package com.example.user.loftmoneytraker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 28-Apr-15.
 */
public class TransactionDetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_transaction, container, false);
        return view;
    }

    public void setTransactionDescription(String description) {
        TextView txtView = (TextView) getView().findViewById(R.id.detailsText);
        txtView.setText(description);
    }
}
