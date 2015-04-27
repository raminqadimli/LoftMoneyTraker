package com.example.user.loftmoneytraker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Product> products = GetProductsList(8) ;
        ProductAdapter adapter = new ProductAdapter(this,products);
        ListView list = (ListView) findViewById(R.id.list_view_id);
        list.setAdapter(adapter);
    }


    private ArrayList<Product> GetProductsList(int size)
    {

        ArrayList<Product> p = new ArrayList<Product>();
        for(int i = 1; i <=size ; i++){

          p.add(new Product("Product" + i,new SimpleDateFormat("dd-MM-yyyy").format(new Date()) ,i*1000));

        }

        return  p;
    }


}
