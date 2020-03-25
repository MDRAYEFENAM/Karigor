package com.mdrayefenam.karigorbangla.Activity.Taker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.mdrayefenam.karigorbangla.Fragment.TakerHome;
import com.mdrayefenam.karigorbangla.Fragment.TakerProfileFragment;
import com.mdrayefenam.karigorbangla.Fragment.TakerEditProfile;
import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.SessionClass.SessionClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class TakerHomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout fragmentContiner;

    private TakerHome home;
    private TakerProfileFragment profile;
    private TakerEditProfile notification;

    private Menu action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_taker_home_page);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentContiner = findViewById(R.id.fragmentContiner);

        home = new TakerHome();
        profile = new TakerProfileFragment();
        notification = new TakerEditProfile();

        ((AppCompatActivity) TakerHomePage.this).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContiner, new TakerHome()).commit();




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

                /*new LoginRegisterClass(TakerProfileFragment.this).removeEmail();
                Intent intent = new Intent( TakerProfileFragment.this,loginactivity.class );
                startActivity( intent );
                finish();*/

                SessionClass.getInstance(getApplicationContext()).logout();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


}
