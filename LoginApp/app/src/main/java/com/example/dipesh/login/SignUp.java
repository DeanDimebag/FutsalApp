package com.example.dipesh.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity implements View.OnClickListener
{


    private  EditText Name, Address, Phone, Email, Username, Password , Conpassword;
    private Button SignUp;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = (EditText)findViewById(R.id.eName);
        Address = (EditText) findViewById(R.id.eAddress);
        Phone =(EditText) findViewById(R.id.ePhone);
        Email = (EditText)findViewById(R.id.eEmail);
        Username = (EditText) findViewById(R.id.eUsername);
        Password = (EditText) findViewById(R.id.ePassword);
        Conpassword = (EditText) findViewById(R.id.cPassword);
        SignUp = (Button) findViewById(R.id.bSignUp);


        SignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

       /* switch (v.getId())
        {
            case R.id.bSignUp:
                startActivity(new Intent(SignUp.this, Login.class));
                break;
        }*/

        if (Name.getText().toString().equals("") || Address.getText().toString().equals("") || Phone.getText().toString().equals("") || Email.getText().toString().equals("") || Username.getText().toString().equals("") || Password.getText().toString().equals(""))
        {
            builder = new AlertDialog.Builder(SignUp.this);
            builder.setTitle("Something went Wrong........!");
            builder.setMessage("Please fill the content......!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else if (!Password.getText().toString().equals(Conpassword.getText().toString()))
        {
            builder = new AlertDialog.Builder(SignUp.this);
            builder.setTitle("Something went Wrong........!");
            builder.setMessage("Your Password are not matching......!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                    Password.setText("");
                    Conpassword.setText("");
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        else
        {
            Database database = new Database(SignUp,this);
            database.execute("SignUp", Name.getText().toString(), Address.getText().toString(), Phone.getText().toString(), Email.getText().toString(), Username.getText().toString(), Password.getText().toString());

            Intent intent = new Intent(SignUp.this,Login.class);
            startActivity(intent);

        }
    }
}
