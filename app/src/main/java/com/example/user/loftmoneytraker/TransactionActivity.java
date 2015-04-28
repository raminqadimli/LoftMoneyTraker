package com.example.user.loftmoneytraker;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Admin on 28-Apr-15.
 */
public class TransactionActivity extends ActionBarActivity {

    public static final String EXTRA_DESCRİPTİON = "Description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        }
        setContentView(R.layout.activity_detail_transaction);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            TransactionDetailFragment detailFragment = (TransactionDetailFragment) getFragmentManager().findFragmentById(R.id.detailTransactionsFragment);
            detailFragment.setTransactionDescription(bundle.getString(EXTRA_DESCRİPTİON));
        }
    }
}
