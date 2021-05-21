package com.example.interndemostorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.interndemostorage.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppCompatDelegate
                .setDefaultNightMode(
                        AppCompatDelegate
                                .MODE_NIGHT_NO);

        BottomFragmentsAdapter navigationAdapter = new BottomFragmentsAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(navigationAdapter);

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.imagesTile:
                        binding.viewPager.setCurrentItem(0);
                        break;
                    case R.id.videoTile:
                        binding.viewPager.setCurrentItem(1);
                        break;
                }
                return true;
            }
        });


        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        binding.bottomNavigationView.getMenu().findItem(R.id.imagesTile).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNavigationView.getMenu().findItem(R.id.videoTile).setChecked(true);
                        break;
                }

                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                else
                    binding.bottomNavigationView.getMenu().getItem(0).setChecked(false);

                binding.bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = binding.bottomNavigationView.getMenu().getItem(position);
           }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}