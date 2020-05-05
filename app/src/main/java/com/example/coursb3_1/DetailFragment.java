package com.example.coursb3_1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    public static final String LONG_TEXT = "long_text";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        if (getView() != null && getContext() != null && getArguments() != null) {
            TextView textView = getView().findViewById(R.id.fragment_liste);
            textView.setText(getArguments().getString(LONG_TEXT));
        }
    }
}
