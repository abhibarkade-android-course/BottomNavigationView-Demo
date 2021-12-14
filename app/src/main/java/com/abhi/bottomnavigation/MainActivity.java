package com.abhi.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.abhi.bottomnavigation.fragments.Fragment_Heart;
import com.abhi.bottomnavigation.fragments.Fragment_Home;
import com.abhi.bottomnavigation.fragments.Fragment_Profile;
import com.abhi.bottomnavigation.fragments.Fragment_Reels;
import com.abhi.bottomnavigation.fragments.Fragment_Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_view = findViewById(R.id.nav_view);

        getSupportFragmentManager().beginTransaction().add(R.id.root, new Fragment_Home()).commit();

        nav_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.item_home:
                        fragment = new Fragment_Home();
                        break;
                    case R.id.item_search:
                        fragment = new Fragment_Search();
                        break;
                    case R.id.item_reels:
                        fragment = new Fragment_Reels();
                        break;
                    case R.id.item_heart:
                        fragment = new Fragment_Heart();
                        break;
                    case R.id.item_profile:
                        fragment = new Fragment_Profile();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.root, fragment).commit();

                return false;
            }
        });
    }
}






