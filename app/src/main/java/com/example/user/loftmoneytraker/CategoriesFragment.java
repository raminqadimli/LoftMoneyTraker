package com.example.user.loftmoneytraker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Admin on 03-May-15.
 */
public class CategoriesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_category, container, false);
        ListView list = (ListView) view.findViewById(R.id.list_view_id);
        list.setAdapter(new CategoryAdapter(getActivity(), getCategoryList()));
        return view;
    }

    private ArrayList<Category> getCategoryList() {
        ArrayList<Category> c = new ArrayList<Category>();
        c.add(new Category("Одежда", R.drawable.closes));
        c.add(new Category("Продукты", R.drawable.product));
        c.add(new Category("Транспорт", R.drawable.transport));
        return c;
    }
}
