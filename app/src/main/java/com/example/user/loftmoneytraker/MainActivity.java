package com.example.user.loftmoneytraker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Transaction> products = GetTransactionList(8);
        TransactionsAdapter adapter = new TransactionsAdapter(this, products);
        ListView list = (ListView) findViewById(R.id.list_view_id);
        list.setAdapter(adapter);
    }

    private ArrayList<Transaction> GetTransactionList(int size) {
        ArrayList<Transaction> p = new ArrayList<Transaction>();
        for (int i = 1; i <= size; i++) {
            p.add(new Transaction("Transaction" + i, new SimpleDateFormat("dd-MM-yyyy").format(new Date()), i * 1000));
        }

        return p;
    }


}
