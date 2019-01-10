package com.example.gregor.festhelp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private SupportFragment supportFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skisova_main);

        homeFragment = new HomeFragment();
        supportFragment = new SupportFragment();


        // Spodnji menu (zbere fragment k je zbran)
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //Prvo nalozi homeFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
    }

    // Spodnji menu
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = homeFragment;
                    break;

                case R.id.nav_urnik:
                    selectedFragment = new EventFragment();
                    break;

                case R.id.nav_kontakt:
                    selectedFragment = supportFragment;
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };

}




