package com.example.bookolik.hobies;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                     goHome();
                    return true;
                case R.id.navigation_search:
                     goSearch();
                    return true;
                case R.id.navigation_person:
                     goProfil();
                    return true;
            }
            return false;
        }
    };

    private void goProfil() {
        profileFragment fragment= new profileFragment();
        android.support.v4.app.FragmentTransaction ft=  getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flayout,fragment);
        ft.commit();
    }

    private void goSearch() {
        searchFragment fragment= new searchFragment();
        android.support.v4.app.FragmentTransaction ft=  getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flayout,fragment);
        ft.commit();
    }

    private void goHome() {
        homeFragment fragment= new homeFragment();
        android.support.v4.app.FragmentTransaction ft=  getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flayout,fragment,"home"); //home etiket birden fazla fragmaent için
        ft.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        homeFragment fragment= new homeFragment();
        android.support.v4.app.FragmentTransaction ft=  getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flayout,fragment);
        ft.commit();
    }

}
