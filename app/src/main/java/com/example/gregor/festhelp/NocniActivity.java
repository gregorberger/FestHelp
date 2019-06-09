package com.example.gregor.festhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NocniActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);

        tabLayout = (TabLayout) findViewById(R.id.urnikTab);
        appBarLayout = (AppBarLayout) findViewById(R.id.urnikBar);
        viewPager = (ViewPager) findViewById(R.id.urnikViewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new GlavniOderFragment(), "Glavni oder");
        adapter.AddFragment(new ElektroOderFragment(), "Elektro oder");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


//        Button nazaj = (Button) findViewById(R.id.nazajButton);
//
//        nazaj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(NocniActivity.this, MainActivity.class);
//                startActivity(in);
//            }
//        });
    }
}
