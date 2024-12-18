package com.example.signup;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Actionbar extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_actionbar);


        bottomNavigationView = findViewById(R.id.bottomnavview);
        frameLayout = findViewById(R.id.framelayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {

                int itemId = Item.getItemId();


                if(itemId == R.id.navhome){
                   loadFragment(new HomeFragment(), false);

                } else if (itemId ==R.id.navsearch ) {
                    loadFragment(new SearcFragment(), false);

                } else if(itemId ==R.id.navNotification){

                    loadFragment(new NotificationFragment(), false);

                } else if(itemId ==R.id.navProfile){

                    loadFragment(new ProfileFragment(), false);
                }

                return true;
            }

        });
        loadFragment(new HomeFragment(), true);

    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

        if(isAppInitialized){
            fragmentTransaction.add(R.id.framelayout, fragment);

          } else {
            fragmentTransaction.replace(R.id.framelayout,fragment);
        }
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}