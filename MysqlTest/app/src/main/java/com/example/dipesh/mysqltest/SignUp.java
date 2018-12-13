package com.example.dipesh.mysqltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity
{

    EditText sname;
    EditText semail;
    EditText spassword;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        sname = (EditText)findViewById(R.id.name);
        semail = (EditText)findViewById(R.id.email);
        spassword = (EditText)findViewById(R.id.password);
        signup = (Button)findViewById(R.id.bSignup);


        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(SignUp.this,Login.class);
                startActivity(intent);

            }
        });


    }
}
