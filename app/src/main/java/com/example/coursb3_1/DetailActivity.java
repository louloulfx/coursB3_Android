package com.example.coursb3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DetailFragment.LONG_TEXT, getIntent().getStringExtra(DetailFragment.LONG_TEXT));
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.detail_layout, fragment).commit();

    }
}
