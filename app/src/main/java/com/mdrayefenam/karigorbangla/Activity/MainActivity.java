package com.mdrayefenam.karigorbangla.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.mdrayefenam.karigorbangla.Fragment.Home;
import com.mdrayefenam.karigorbangla.Fragment.ProfileFragment;
import com.mdrayefenam.karigorbangla.Fragment.Notification;
import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.SessionClass.SessionClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout fragmentContiner;

    private Home home;
    private ProfileFragment profile;
    private Notification notification;

    private Menu action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentContiner = findViewById(R.id.fragmentContiner);

        home = new Home();
        profile = new ProfileFragment();
        notification = new Notification();

        ((AppCompatActivity) MainActivity.this).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContiner, new Home()).commit();




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_item:
                        InitialFragment(home);
                        return true;

                    case R.id.news_feed_item:
                        InitialFragment(profile);
                        return true;

                    case R.id.search_item:
                        InitialFragment(notification);
                        return true;

                }
             return false;

            }
        });
    }



   public void  InitialFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContiner,fragment);
        fragmentTransaction.commit();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        action = menu;

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_logout:

                /*new LoginRegisterClass(ProfileFragment.this).removeEmail();
                Intent intent = new Intent( ProfileFragment.this,loginactivity.class );
                startActivity( intent );
                finish();*/

                SessionClass.getInstance(getApplicationContext()).logout();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


}
