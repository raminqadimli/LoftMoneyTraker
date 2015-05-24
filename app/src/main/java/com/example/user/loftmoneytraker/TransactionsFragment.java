package com.example.user.loftmoneytraker;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.activeandroid.query.Select;
import com.melnykov.fab.FloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;


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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(layoutManager);


        fab.attachToRecyclerView(list);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewTransactionActivity_.intent(getActivity()).start();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Transaction>>() {
            @Override
            public Loader<List<Transaction>> onCreateLoader(int id, Bundle args) {
                AsyncTaskLoader<List<Transaction>> transactionsLoader = new AsyncTaskLoader<List<Transaction>>(getActivity()) {
                    @Override
                    public List<Transaction> loadInBackground() {
                        return getTransactions();
                    }
                };
                transactionsLoader.forceLoad();
                return transactionsLoader;
            }

            @Override
            public void onLoadFinished(Loader<List<Transaction>> loader, List<Transaction> data) {
                list.setAdapter(new TransactionsAdapter(data));
            }

            @Override
            public void onLoaderReset(Loader<List<Transaction>> loader) {

            }
        });
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

    private List<Transaction> getTransactions() {
        return new Select().from(Transaction.class).orderBy("CreateDate Desc").execute();
    }

    private void sendDetailTransaction(String description) {
        mListener.onItemSelected(description);
    }
}
