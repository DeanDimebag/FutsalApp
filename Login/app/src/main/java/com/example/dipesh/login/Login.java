package com.example.dipesh.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener
{

    //private EditText Username;
    //private EditText Password;
    //private Button Login;
    private TextView SignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Username = (EditText) findViewById(R.id.eUsername);
        //Password = (EditText) findViewById(R.id.ePassword);
        //Login = (Button) findViewById(R.id.bLogin);
        SignUp = (TextView)findViewById(R.id.linkSignUp);

        //Login.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }



    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            /*case R.id.bLogin:
                startActivity(new Intent(Login.this, Menu.class));
                break;*/


            case R.id.linkSignUp:
                startActivity(new Intent(Login.this, SignUp.class));
                break;
        }

    }
}
