package com.sekawan.studio.RecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<Data> phoneList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        phoneList = new ArrayList<>();
        adapter = new MainAdapter(this, phoneList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        preparePhones();


    }
    private void preparePhones() {
        int[] covers = new int[]{
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher,
                R.drawable.ic_launcher
        };

        Data a = new Data("Acer", 13, covers[0]);
        phoneList.add(a);

        a = new Data("Asus", 8, covers[1]);
        phoneList.add(a);

        a = new Data("BlackBerry", 11, covers[2]);
        phoneList.add(a);

        a = new Data("HTC", 11, covers[3]);
        phoneList.add(a);

        a = new Data("BlackBerry", 11, covers[4]);
        phoneList.add(a);

        a = new Data("HTC", 11, covers[5]);
        phoneList.add(a);

        a = new Data("BlackBerry", 11, covers[6]);
        phoneList.add(a);

        a = new Data("HTC", 11, covers[7]);
        phoneList.add(a);


        adapter.notifyDataSetChanged();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

}

