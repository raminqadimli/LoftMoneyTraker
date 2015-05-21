package com.example.user.loftmoneytraker;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements TransactionsFragment.OnListTransactionListener {

    @ViewById
    Toolbar mainToolbar;

    private Drawer.Result navigationDrawer;

    @AfterViews
    void init() {
        setSupportActionBar(mainToolbar);
        createNavigationDrawer();
        showFragment(0);
        setTitle(getResources().getString(R.string.drawer_item_transaction));
    }

    private void createNavigationDrawer() {
        AccountHeader.Result accountheader = createAccountHeader();

        navigationDrawer = new Drawer()
                .withActivity(this)
                .withToolbar(mainToolbar)
                .withAccountHeader(accountheader)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(getDrawerItems())
                .withOnDrawerItemClickListener(new DrawerItemClickListener())
                .build();
    }

    private AccountHeader.Result createAccountHeader() {
        IProfile profile = createProfile();

        return new AccountHeader()
                .withActivity(this)
                .addProfiles(profile)
                .withHeaderBackground(R.drawable.navigation_head_background)
                .build();
    }

    private IProfile createProfile() {
        return new ProfileDrawerItem()
                .withName(getResources().getString(R.string.user_name))
                .withEmail(getResources().getString(R.string.user_mail))
                .withIcon(getResources().getDrawable(R.drawable.ic_verified_user_black_48dp));
    }

    private IDrawerItem[] getDrawerItems() {
        return new IDrawerItem[]{new PrimaryDrawerItem().withName(R.string.drawer_item_transaction).withIcon(R.drawable.drawer_transactions).withBadge("5").withIdentifier(1),
                new PrimaryDrawerItem().withName(R.string.drawer_item_category).withIcon(R.drawable.drawer_category).withIdentifier(1),
                new PrimaryDrawerItem().withName(R.string.drawer_item_report).withIcon(R.drawable.drawer_report).withIdentifier(1),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(R.drawable.drawer_settings).withIdentifier(2),
                new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(R.drawable.drawer_help).withIdentifier(2)};
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    public void onBackPressed() {
        if (navigationDrawer != null && navigationDrawer.isDrawerOpen()) {
            navigationDrawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
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

    private class DrawerItemClickListener implements Drawer.OnDrawerItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
            if (iDrawerItem instanceof PrimaryDrawerItem) {
                setTitle(((PrimaryDrawerItem) iDrawerItem).getNameRes());
                showFragment(i);
            }
        }
    }

    private void showFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new TransactionsFragment_();
                break;
            case 1:
                fragment = new CategoriesFragment_();
                break;
            case 2:
                fragment = new ReportsFragment_();
                break;
        }
        if (fragment != null) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
    }
}
