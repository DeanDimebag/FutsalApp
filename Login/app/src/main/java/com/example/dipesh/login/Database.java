package com.example.dipesh.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class Database extends AsyncTask <String, String , String>
{

    String register_url = "http//127.0.0.1/loginapp/register.php";
    String login_url = "http//127.0.0.1/loginapp/login.php";

    Context cont;
    ProgressDialog progressDialog;
    Activity activity;
    AlertDialog.Builder builder;

    public Database(Button signUp, Context cont)
        {
            this.cont = cont;
            activity = (Activity) cont;
        }


    @Override
    protected void onPreExecute()
        {
            builder = new AlertDialog.Builder(activity);
            progressDialog = new ProgressDialog(cont);
            progressDialog.setTitle("Please Wait.");
            progressDialog.setMessage("Connecting to server.........");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

    @Override
    protected String doInBackground(String... params)
    {

        String method = params[0];

        if (method.equals("register"))
        {
            try
            {

                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String Name = params[1];
                String Address = params[2];
                String Phone = params[3];
                String Email = params[4];
                String Username = params[5];
                String Password = params[6];

                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(Name, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(Address, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(Phone, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(Email, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(Username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(Password, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream)));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line + "\n");
                }

                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();

            }
            catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }

            catch (IOException e)
                {
                    e.printStackTrace();
                }

            catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
        else if (method.equals("login"))
        {
            try
            {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String username, password;
                username = params [1];
                password = params [2];

                String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream)));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line + "\n");
                }

                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();

            }
            catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }


            catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }

            catch (ProtocolException e)
                {
                    e.printStackTrace();
                }

            catch (IOException e)
                {
                    e.printStackTrace();
                }

            catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values)
    {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String json)
    {

        try
        {
            progressDialog.dismiss();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            JSONObject JO = jsonArray.getJSONObject(0);
            String code = JO.getString("code");
            String message = JO.getString("message");
            if (code.equals("reg_true"))
                {
                    showDialog ("Registration Success",message,code);
                }
                    else if (code.equals("reg_false"))
                    {
                        showDialog("Registration Failed",message,code);
                    }


                    /*else if (code.equals("login_true"))
                    {
                        Intent intent = new Intent(activity,Menu.class);
                        intent.putExtra("message",message);
                        activity.startActivity(intent);
                    }
                        else if (code.equals("login_false"))
                        {
                            showDialog("Login Error........",message,code);

                        }*/
        }
        catch (JSONException e)
            {
                e.printStackTrace();
            }

    }

    public void showDialog(String title, String message, String code)
    {

        builder.setTitle(title);
        if (code.equals("reg_true")||code.equals("reg_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                        activity.finish();
                    }
                });
        }

            else if (code.equals("login_false"))
                {
                    builder.setMessage(message);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                            EditText username, password;
                            username = (EditText)activity.findViewById(R.id.eUsername);
                            password = (EditText)activity.findViewById(R.id.ePassword);
                            username.setText("");
                            password.setText("");
                            dialog.dismiss();

                        }
                    });
                }

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
