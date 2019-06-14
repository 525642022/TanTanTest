package com.example.tantantest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView tantan_rv;
    private List<String> list = new ArrayList<>();
    private CommonAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CardConfig.initConfig(this);
        setContentView(R.layout.activity_main);
        tantan_rv = findViewById(R.id.tantan_rv);
        initData();
        tantan_rv.setLayoutManager(new TanTanLayoutManager());
        mAdapter = new CommonAdapter<String>(this, R.layout.item_swipe_card, list) {
            @Override
            protected void convert(ViewHolder holder, String o, int position) {

            }

        };
        ItemTouchHelper.Callback callback = new TanTanTouchCallback(tantan_rv, mAdapter, list);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(tantan_rv);
        tantan_rv.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            list.add("test");
        }
    }
}
