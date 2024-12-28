

package com.example.bottom_nav;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.bottom_nav.MusicFragment;
import com.example.bottom_nav.NewsFragment;
import com.example.bottom_nav.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView Butto;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.favorites);


        Butto = findViewById(R.id.btn_open_drawer);
        Butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });
    }


    favoritesFragment favoritesFragment = new favoritesFragment();
    MusicFragment musicFragment = new MusicFragment();
    NewsFragment newsFragment = new NewsFragment();
    placesFragment placesFragment = new placesFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.favorites:
                fragment = favoritesFragment;
                break;
            case R.id.News:
                fragment = newsFragment;
                break;
            case R.id.places:
                fragment = placesFragment;
                break;
            case R.id.music:
                fragment = musicFragment;
                break;
        }

        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.lfFragment, fragment)
                    .commit();
        }

        return true;
    }


    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() != R.id.favorites) {
            bottomNavigationView.setSelectedItemId(R.id.favorites);
        } else {
            super.onBackPressed();
        }
    }



}