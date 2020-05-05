package com.example.coursb3_1;

import android.os.Bundle;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> textList = null;


    public MainPagerAdapter(FragmentManager fragmentManager, List<String> textList) {
        super(fragmentManager);
        this.textList = textList;
    }

    @Override
    public Fragment getItem(int position)
    {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MainFragment.TEXT, textList.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount()
    {

        return textList.size();
    }

    String getTextePage(int position)
    {
        return textList.get(position);
    }
}
