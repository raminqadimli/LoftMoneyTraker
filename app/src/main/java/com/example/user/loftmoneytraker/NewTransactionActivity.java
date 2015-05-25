package com.example.user.loftmoneytraker;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.activeandroid.query.Select;
import com.melnykov.fab.FloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import java.util.Date;

@EActivity(R.layout.activity_new_transaction)
public class NewTransactionActivity extends AppCompatActivity {

    @ViewById
    Toolbar mainToolbar;

    @ViewById
    FloatingActionButton fab;

    @ViewById(R.id.name)
    EditText transactionName;

    @ViewById(R.id.sum)
    EditText transactionSum;

    @AfterViews
    void init() {
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getResources().getString(R.string.new_transaction));
        setHintFromLastTransaction();

    }

    @Click(R.id.fab)
    void addTransaction() {
        if (isValid()) {
            new Transaction(transactionName.getText().toString(), Integer.parseInt(transactionSum.getText().toString()), new Date()).save();
            finish();
        }
    }

    private void setHintFromLastTransaction() {
        Transaction lastTransaction = getLastTransaction();
        if (lastTransaction != null) {
            transactionName.setHint(lastTransaction.getName());
            transactionSum.setHint(String.valueOf(lastTransaction.getSum()));
        }
    }

    private Transaction getLastTransaction() {
        return new Select().from(Transaction.class).orderBy("CreateDate Desc").executeSingle();
    }

    private boolean isValid() {
        boolean isValid = true;

        if (isEmpty(transactionName)) {
            transactionName.setError(getResources().getString(R.string.error_transaction_name));
            isValid = false;
        }
        if (isEmpty(transactionSum)) {
            transactionSum.setError(getResources().getString(R.string.error_transaction_sum));
            isValid = false;
        }
        return isValid;
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

    @OptionsItem
    void homeSelected() {
        onBackPressed();
    }
}
