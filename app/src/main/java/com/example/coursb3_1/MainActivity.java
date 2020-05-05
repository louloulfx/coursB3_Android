package com.example.coursb3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager = null;
    private MainPagerAdapter mainPagerAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);

        String text = getString(R.string.text);
        List<String> textList = new ArrayList<>();
        for (int i = 0; i< text.length(); i += 850) {
            textList.add(text.substring(i, Math.min(i + 850, text.length())));
        }

        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), textList);
        viewPager.setAdapter(mainPagerAdapter);

    }

    public int getNbCaracteres()
    {
        String textePage = mainPagerAdapter.getTextePage(viewPager.getCurrentItem());

        return textePage.split("\\s+").length;
    }

    public int getNbPage()
    {
        return viewPager.getCurrentItem() + 1;
    }

}
