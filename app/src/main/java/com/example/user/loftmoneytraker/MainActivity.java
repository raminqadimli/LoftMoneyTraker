package com.example.user.loftmoneytraker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements TransactionsFragment.OnListTransactionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(String description) {
        TransactionDetailFragment detailFragment = (TransactionDetailFragment) getFragmentManager().findFragmentById(R.id.detailTransactionsFragment);
        if (detailFragment != null && detailFragment.isInLayout()) {
            detailFragment.setTransactionDescription(description);
        } else {
            Intent intent = new Intent(getApplicationContext(), TransactionActivity.class);
            intent.putExtra(TransactionActivity.EXTRA_DESCRİPTİON, description);
            startActivity(intent);
        }
    }
}
