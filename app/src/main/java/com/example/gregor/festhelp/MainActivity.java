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
    private EventFragment eventFragment;
    private MapaFragment mapaFragment;
    private RacunFragment racunFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skisova_main);

        homeFragment = new HomeFragment();
        supportFragment = new SupportFragment();
        eventFragment = new EventFragment();
        mapaFragment = new MapaFragment();
        racunFragment = new RacunFragment();

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
                    selectedFragment = eventFragment;
                    break;

                case R.id.nav_kontakt:
                    selectedFragment = supportFragment;
                    break;

                case R.id.nav_mapa:
                    selectedFragment = mapaFragment;
                    break;

                case R.id.nav_račun:
                    selectedFragment = racunFragment;
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };

}




