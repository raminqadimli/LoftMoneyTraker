package com.example.user.loftmoneytraker;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements TransactionsFragment.OnListTransactionListener {

    private ListView drawerListView;
    private DrawerLayout drawerLayout;
    private Toolbar main_toolbar;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        main_toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerListView = (ListView) findViewById(R.id.left_drawer);
        drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, getResources().getStringArray(R.array.drawer_items)));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener());

        if (main_toolbar != null) {
            setSupportActionBar(main_toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, main_toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);

        drawerListView.setItemChecked(0, true);
        showFragment(0);
        setTitle((String) drawerListView.getItemAtPosition(0));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
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

    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            setTitle((String) parent.getItemAtPosition(position));
            drawerListView.setItemChecked(position, true);
            drawerLayout.closeDrawer(drawerListView);
            showFragment(position);
        }
    }

    private void showFragment(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new TransactionsFragment();
                break;
            case 1:
                fragment = new CategoriesFragment();
                break;
            case 2:
                fragment = new ReportsFragment();
                break;
        }
        if (fragment != null) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
    }
}
