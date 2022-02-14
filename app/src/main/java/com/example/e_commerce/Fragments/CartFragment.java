package com.example.e_commerce.Fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_commerce.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    private TextView setTitle;

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);




        return view;
    }



}