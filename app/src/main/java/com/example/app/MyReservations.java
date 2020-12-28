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
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyReservations extends AppCompatActivity {

    private DBHelper db;
    String username;
    LinearLayout pole;
    TextView grad, datum, vreme, lokacija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_reservations);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString("username", "null");

        db = new DBHelper(this);
        pole = (LinearLayout) findViewById(R.id.l1);
        pole.setVisibility(View.INVISIBLE);
        pole = (LinearLayout) findViewById(R.id.l2);
        pole.setVisibility(View.INVISIBLE);
        pole = (LinearLayout) findViewById(R.id.l3);
        pole.setVisibility(View.INVISIBLE);
        String check = db.checkRes(username);

        if(check != "0") {
            String [] niza = check.split(",");
            pole = (LinearLayout) findViewById(R.id.l1);
            pole.setVisibility(View.VISIBLE);
            grad = (TextView) findViewById(R.id.grad1);
            grad.setText(niza[1]);
            datum = (TextView) findViewById(R.id.datum1);
            datum.setText(niza[2]);
            vreme = (TextView) findViewById(R.id.vreme1);
            vreme.setText(niza[3]);
            lokacija = (TextView) findViewById(R.id.lokacija1);
            lokacija.setText(niza[4]);

            if(niza.length>5) {
                pole = (LinearLayout) findViewById(R.id.l2);
                pole.setVisibility(View.VISIBLE);
                grad = (TextView) findViewById(R.id.grad2);
                grad.setText(niza[5]);
                datum = (TextView) findViewById(R.id.datum2);
                datum.setText(niza[6]);
                vreme = (TextView) findViewById(R.id.vreme2);
                vreme.setText(niza[7]);
                lokacija = (TextView) findViewById(R.id.lokacija2);
                lokacija.setText(niza[8]);

                if(niza.length>9) {
                    pole = (LinearLayout) findViewById(R.id.l3);
                    pole.setVisibility(View.VISIBLE);
                    grad = (TextView) findViewById(R.id.grad3);
                    grad.setText(niza[9]);
                    datum = (TextView) findViewById(R.id.datum3);
                    datum.setText(niza[10]);
                    vreme = (TextView) findViewById(R.id.vreme3);
                    vreme.setText(niza[11]);
                    lokacija = (TextView) findViewById(R.id.lokacija3);
                    lokacija.setText(niza[12]);
                }
            }
        }

        /*Button button1 = (Button) findViewById(R.id.b1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pole = (LinearLayout) findViewById(R.id.l1);
                pole.setVisibility(View.GONE);
                db.delete();
            }
        });*/

    }
}