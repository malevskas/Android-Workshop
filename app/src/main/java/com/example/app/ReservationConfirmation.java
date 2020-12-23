package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReservationConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_confirmation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String grad = intent.getStringExtra("grad");
        TextView gradot = (TextView) findViewById(R.id.grad);
        gradot.setText(grad);
        String datum = intent.getStringExtra("datum");
        TextView datumot = (TextView) findViewById(R.id.datum);
        datumot.setText(datum);
        String vreme = intent.getStringExtra("vreme");
        TextView vremeto = (TextView) findViewById(R.id.vreme);
        vremeto.setText(vreme);
    }
}