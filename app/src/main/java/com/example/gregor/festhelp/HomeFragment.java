package com.example.gregor.festhelp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    // Za slider1 (slike dogodka)
    private ViewPager viewPager;
    private SlideAdapter myAdapter;

    // Za slider2 (sponzorji)
    private ViewPager viewPager2;
    private SlideAdapter2 myAdapter2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_skisova_main, container, false);

        // Za slider1 (slike dogodka)
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        myAdapter = new SlideAdapter(v.getContext());
        viewPager.setAdapter(myAdapter);

        // Za slider2 (sponzorji)
        viewPager2 = (ViewPager) v.findViewById(R.id.viewpager2);
        myAdapter2 = new SlideAdapter2(v.getContext());
        viewPager2.setAdapter(myAdapter2);


        return v;
    }

}
