package com.example.interndemostorage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class BottomFragmentsAdapter extends FragmentStatePagerAdapter {

    public BottomFragmentsAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

    }

    public BottomFragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ImagesFragment();
            case 1:
                return new VideosFragment();
            default:
                return new ImagesFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;       //Number of navigation at the Bottom
    }
}
