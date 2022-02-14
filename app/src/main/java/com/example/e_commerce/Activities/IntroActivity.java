package com.example.e_commerce.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_commerce.Adapter.PagerAdapter;
import com.example.e_commerce.R;

public class IntroActivity extends AppCompatActivity  implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private ImageView imageviewOne,ImageviewTwo,Imageviewthree;
    int total =3, count=1;
    private TextView Skipbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();
        Window window = getWindow();

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        viewPager = findViewById(R.id.viewpagerid);
        imageviewOne =  findViewById(R.id.first_indicator);
        ImageviewTwo =  findViewById(R.id.second_indicator);
        Imageviewthree =  findViewById(R.id.third_indicator);
        Skipbutton = findViewById(R.id.skipped);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(this);

        Skipbutton.setOnClickListener(this);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        count = 0;
        count = position+1;
        switch (position){
            case 0:
                imageviewOne.setImageResource(R.drawable.active_circle);
                ImageviewTwo.setImageResource(R.drawable.disable_circle);
                Imageviewthree.setImageResource(R.drawable.disable_circle);
                break;
            case 1:
                ImageviewTwo.setImageResource(R.drawable.active_circle);
                imageviewOne.setImageResource(R.drawable.disable_circle);
                Imageviewthree.setImageResource(R.drawable.disable_circle);
                break;
            case 2:
                Imageviewthree.setImageResource(R.drawable.active_circle);
                imageviewOne.setImageResource(R.drawable.disable_circle);
                ImageviewTwo.setImageResource(R.drawable.disable_circle);
                break;
            default:
                imageviewOne.setImageResource(R.drawable.active_circle);
                ImageviewTwo.setImageResource(R.drawable.disable_circle);
                Imageviewthree.setImageResource(R.drawable.disable_circle);
                break;
        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.skipped){
            Intent intent = new Intent(IntroActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}