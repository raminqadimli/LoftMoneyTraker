package com.example.user.loftmoneytraker;

import android.app.Fragment;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * Created by Admin on 03-May-15.
 */
@EFragment(R.layout.fragment_list_category)
public class CategoriesFragment extends Fragment {

    @ViewById(R.id.list_view_id)
    ListView list;

    @AfterViews
    void init() {
        list.setAdapter(new CategoryAdapter(getActivity(), getCategoryList()));
    }

    private ArrayList<Category> getCategoryList() {
        ArrayList<Category> c = new ArrayList<Category>();
        c.add(new Category("Одежда", R.drawable.closes));
        c.add(new Category("Продукты", R.drawable.product));
        c.add(new Category("Транспорт", R.drawable.transport));
        return c;
    }
}
