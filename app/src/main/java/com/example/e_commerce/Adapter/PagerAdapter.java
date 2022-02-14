package com.example.e_commerce.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.e_commerce.Fragments.FragmentOne;
import com.example.e_commerce.Fragments.FragmentThree;
import com.example.e_commerce.Fragments.FragmentTwo;

public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return new FragmentOne();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
