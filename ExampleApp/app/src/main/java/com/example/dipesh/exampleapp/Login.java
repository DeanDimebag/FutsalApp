package com.example.dipesh.exampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    final String correctusername ="dipesh";
    final String correctpassword = "dipesh";
    EditText Username;
    EditText Password;
    Button bLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.eUsername);
        Password = (EditText)findViewById(R.id.ePassword);
        bLogin = (Button)findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String username = Username.getText().toString();
                String password = Password.getText().toString();

                if (username.equals(correctusername) && password.equals(correctpassword))
                {
                    Toast loginsucessToast = Toast.makeText(getApplicationContext(),"Login Successfully....!", Toast.LENGTH_LONG);
                    loginsucessToast.show();

                    Log.d("Button", "Login Successfully..........!");
                    Log.d("Button", "Username: " + username);
                    Log.d("Button", "Password: " + password);

                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);

                }
                else
                {
                    Toast loginfailToast = Toast.makeText(getApplicationContext(), "Login Failed......!", Toast.LENGTH_LONG);
                    loginfailToast.show();

                    Log.d("Button", "Login Failed........!");
                }
            }
        });
    }
}
