package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LogReg extends AppCompatActivity {

    DBHelper db;
    EditText username;
    EditText password;
    TextView error;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logreg);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        db = new DBHelper(this);

        error = (TextView) findViewById(R.id.error1);
        error.setVisibility(View.GONE);
        error = (TextView) findViewById(R.id.error2);
        error.setVisibility(View.GONE);
        error = (TextView) findViewById(R.id.ok);
        error.setVisibility(View.GONE);
    }

    public void login(View view) {
        db.test();
        username = (EditText) findViewById(R.id.log_name);
        password = (EditText) findViewById(R.id.log_pass);
        String name = username.getText().toString();
        String pass = password.getText().toString();
        boolean check = db.checkLogin(name, pass);
        if(check) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("username", name);
            editor.commit();
            Intent intent = new Intent(this, Cities.class);
            startActivity(intent);
        }
        else {
            error = (TextView) findViewById(R.id.error1);
            error.setVisibility(View.VISIBLE);
        }
    }

    public void register(View view) {
        username = (EditText) findViewById(R.id.reg_name);
        password = (EditText) findViewById(R.id.reg_pass);
        String name = username.getText().toString();
        String pass = password.getText().toString();
        boolean check = db.registerUser(name, pass);
        if(check) {
            error = (TextView) findViewById(R.id.error2);
            error.setVisibility(View.GONE);
            error = (TextView) findViewById(R.id.ok);
            error.setVisibility(View.VISIBLE);
        }
        else {
            error = (TextView) findViewById(R.id.error2);
            error.setVisibility(View.VISIBLE);
        }
    }

}