package com.example.dipesh.mysqltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    final String correctusername ="dipesh";
    final String correctpassword = "dipesh";
    EditText Username;
    EditText Password;
    Button Login;
    TextView Register;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText)findViewById(R.id.eUsername);
        Password = (EditText)findViewById(R.id.ePassword);
        Login = (Button)findViewById(R.id.bLogin);
        Register = (TextView)findViewById(R.id.bRegister);


        Login.setOnClickListener(new View.OnClickListener()
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

                    Intent intent = new Intent(com.example.dipesh.mysqltest.Login.this,Menu_test.class);
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



        Register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });


    }

   /* public void bLogin(View view)
    {
        String user = Username.getText().toString();
        String pass = Password.getText().toString();


    }*/
}
