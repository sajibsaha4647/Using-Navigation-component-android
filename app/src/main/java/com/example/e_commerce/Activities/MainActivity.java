package com.example.e_commerce.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity   {

    private Fragment fragment ;
    private ImageView DrowerIcon;
    private TextView TitleText;
    private SharedPreferences SavedatastatePref;
    private SharedPreferences.Editor editor;
   private CardView middleCard;
   private DrawerLayout drawerLayout ;

   private AppBarConfiguration appBarConfiguration;


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

        middleCard = findViewById(R.id.hom);

        //drower layout
         drawerLayout = findViewById(R.id.DrowerId);
        NavigationView navigationView = findViewById(R.id.nav_view); //side drower


        MenuItem item = navigationView.getMenu().findItem(R.id.wishlistFragment2);
        item.setCheckable(true);
        item.setChecked(true);


        //bottom layout
        //Initialize Bottom Navigation View.
        BottomNavigationView navView = findViewById(R.id.bottom_nav_view);

        //Pass the ID's of Different destinations
         appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.cartFragment2,R.id.wishlistFragment2, R.id.categoryFragment, R.id.userFragment)
                .setDrawerLayout(drawerLayout)
                .build();

        //Initialize NavController. Bottom tab
        NavController navController = Navigation.findNavController(this, R.id.Navhostid);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);

        middleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(MainActivity.this,R.id.Navhostid).navigate(R.id.homeFragment);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.Navhostid);
        return   NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }


    @SuppressLint("WrongConstant")
    public void openDrawer() { //this connect with fragment
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DrowerId);
        drawer.openDrawer(Gravity.START);
    }


}
