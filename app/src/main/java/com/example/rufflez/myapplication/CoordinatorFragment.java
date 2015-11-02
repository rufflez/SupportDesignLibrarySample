package com.example.rufflez.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rufflez on 6/21/15.
 */
public class CoordinatorFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.coordinator_layout, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        setupRecyclerView(recyclerView);
        return rootView;
    }

    private void setupRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),
                VersionModel.data));
    }

    public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder>{
        private String[] mValues;
        private Context mContext;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public final View mView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

        }

        public String getValueAt(int position) {
            return mValues[position];
        }

        public SimpleStringRecyclerViewAdapter(Context context, String[] items) {
            mContext = context;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mTextView.setText(mValues[position]);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, getValueAt(position), Snackbar.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.length;
        }
    }
}
