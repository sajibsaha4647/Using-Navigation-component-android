package com.example.e_commerce.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e_commerce.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class WishlistFragment extends Fragment {

    private TextView settitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_wishlist, container, false);


        return view;
    }
}