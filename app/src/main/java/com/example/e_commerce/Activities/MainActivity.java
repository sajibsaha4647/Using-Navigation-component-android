package com.example.e_commerce.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.Fragments.CartFragment;
import com.example.e_commerce.Fragments.CategoryFragment;
import com.example.e_commerce.Fragments.HomeFragment;
import com.example.e_commerce.Fragments.UserFragment;
import com.example.e_commerce.Fragments.WishlistFragment;
import com.example.e_commerce.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment fragment ;
    private ImageView imageCategory,imageWishlist,imageCart,imageUser,imageHome,imageBackicon;
    private TextView TitleText;
    private LinearLayout layout,headerLayout;
    private SharedPreferences SavedatastatePref;
    private SharedPreferences.Editor editor;
    String currentFragmentName;

    FragmentManager fragmentManagerback = this.getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.orange));


        imageCategory = findViewById(R.id.home);
        imageCategory.setOnClickListener(this);

        imageWishlist = findViewById(R.id.home1);
        imageWishlist.setOnClickListener(this);

        imageCart = findViewById(R.id.home3);
        imageCart.setOnClickListener(this);

        imageUser = findViewById(R.id.home4);
        imageUser.setOnClickListener(this);

        imageHome = findViewById(R.id.hom);
        imageHome.setOnClickListener(this);

        TitleText = findViewById(R.id.titleid);
        imageBackicon = findViewById(R.id.backicon);
        layout = findViewById(R.id.header_titleid);
        headerLayout = findViewById(R.id.headerLayout);




        fragment = new HomeFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ChangeFrame, fragment,null);
        fragmentTransaction
                .commit();
        layout.setVisibility(View.GONE);




        imageBackicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackFragment();
            }
        });

    }

    private void changeBackFragment() {
        if (currentFragmentName.equals("hom")){
            layout.setVisibility(View.GONE);
            headerLayout.setVisibility(View.VISIBLE);
        }else {
            layout.setVisibility(View.VISIBLE);
            headerLayout.setVisibility(View.GONE);
        }
    }


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

        currentFragmentName=fragment.getTag();
        Log.wtf("onbackPressed",currentFragmentName);
        if (currentFragmentName != null){
            if(currentFragmentName.equals("hom")){
                layout.setVisibility(View.GONE);
                headerLayout.setVisibility(View.VISIBLE);
            }else {
                layout.setVisibility(View.VISIBLE);
                headerLayout.setVisibility(View.GONE);
            }
        }



    }

    @Override
    public void onBackPressed(){
        Log.wtf("onbackPressed",currentFragmentName);
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public void onClick(View view) {

       switch (view.getId()){
           case R.id.home:
               loadFragment(new CategoryFragment(),"category");
               TitleText.setText("Category");
              break;
           case R.id.home1:
               loadFragment(new WishlistFragment(),"wise_list");
               TitleText.setText("Wishlist");
               break;
           case R.id.home3:
               loadFragment(new CartFragment(),"cart");
               TitleText.setText("Cart");
               break;
           case R.id.home4:
               loadFragment(new UserFragment(),"account");
               TitleText.setText("Account");
               break;
           case R.id.hom:
               loadFragment(new UserFragment(),"hom");
               break;



       }
    }
    public boolean loadFragment(Fragment fragment,String fragmentName) {
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.ChangeFrame,fragment,fragmentName)
                    .addToBackStack(fragmentName)
                    .commit();

            return true;
        }
        return false;
    }
}