package com.example.part6_18;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Lab18_3Activity extends AppCompatActivity implements View.OnClickListener{
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab18_3);
        Toolbar toolBar = (Toolbar) findViewById(R.id.lab3_toolbar);
        setSupportActionBar(toolBar);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.lab3_recycler);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item=" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(list));

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.lab3_fab);
        fab.setOnClickListener(this);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.lab3_coordinator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lab3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<String> list;

        public MyAdapter(List<String> list) {
            this.list = list;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            return new MyViewHolder(view);
        }
        @Override
        public void onBindViewHolder(MyViewHolder viewHolder, int position) {
            String text = list.get(position);
            viewHolder.title.setText(text);
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(coordinatorLayout, "I am SnackBar", Snackbar.LENGTH_LONG)
                .setAction("MoreAtion", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //.......................
                    }
                })
                .show();
    }
}
