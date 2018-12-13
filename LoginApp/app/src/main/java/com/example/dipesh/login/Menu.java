package com.example.dipesh.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import static com.example.dipesh.login.R.id.bLogout;

public class Menu extends AppCompatActivity implements View.OnClickListener
{

    private  Button Logout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Logout = (Button) findViewById(bLogout);

        Logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bLogout:
                startActivity(new Intent(this, Login.class));
                break;
        }

    }
}
