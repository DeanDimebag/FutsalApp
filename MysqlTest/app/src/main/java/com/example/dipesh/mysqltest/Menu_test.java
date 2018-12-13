package com.example.dipesh.mysqltest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class Menu_test extends AppCompatActivity
{

    public static FragmentManager fragmentManager;


    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;


    private HomeFragment homeFragment;
    private  NotificationFragment notificationFragment;
    private AccountFragment accountFragment;
    private Context cont;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_frame,new HomeFragment());
        fragmentTransaction.commit();

       /* if (findViewById(R.id.main_frame)!=null)
        {
            if (savedInstanceState!=null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //Login login = new Login(Context context);
            fragmentTransaction.add(R.id.main_frame,homeFragment,null);
            fragmentTransaction.commit();
        }*/



        bottomNavigationView = (BottomNavigationView)findViewById(R.id.main_nav);
        frameLayout = (FrameLayout) findViewById(R.id.main_frame);

        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        accountFragment = new AccountFragment();

        setFragment(homeFragment);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId() )
                {

                    case R.id.nav_home:
                        bottomNavigationView.setItemBackgroundResource(R.color.design_default_color_primary);
                        setFragment(homeFragment);
                        return true;


                    case R.id.nav_notif:
                        bottomNavigationView.setItemBackgroundResource(R.color.design_default_color_primary);
                        setFragment(notificationFragment);
                        return true;



                    case R.id.nav_account:
                        bottomNavigationView.setItemBackgroundResource(R.color.design_default_color_primary);
                        setFragment(accountFragment);
                        return true;

                        default:
                            return false;

                }


            }
        });





    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }

}
