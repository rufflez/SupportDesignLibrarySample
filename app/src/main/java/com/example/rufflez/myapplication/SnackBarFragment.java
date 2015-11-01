package com.example.rufflez.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by rufflez on 6/21/15.
 */
public class SnackBarFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.floating_action_button, container, false);
        FloatingActionButton button = (FloatingActionButton)rootView.findViewById(R.id.fab2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "This is a snackbar", Snackbar.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

}
