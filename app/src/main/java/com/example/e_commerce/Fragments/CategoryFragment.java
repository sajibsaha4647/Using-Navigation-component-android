package com.example.e_commerce.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.Activities.MainActivity;
import com.example.e_commerce.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    private TextView setTitle;
    private ImageView imageView;
    private Activity activity = getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        Toast.makeText(getContext(),"category",Toast.LENGTH_SHORT).show();

        setTitle = view.findViewById(R.id.titleid) ;

        setTitle.setText("Category");

        imageView = view.findViewById(R.id.backicon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().onBackPressed();
            }
        });

        return view;
    }
}