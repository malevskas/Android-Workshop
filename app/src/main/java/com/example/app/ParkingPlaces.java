package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ParkingPlaces extends AppCompatActivity {

    RecyclerView myRecyclerView;
    ParkingPlacesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_places);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        List<String> pSkopje = Arrays.asList("yeyey", "hdhdh");
        List<String> pKumanovo = Arrays.asList("1");
        List<String> pTetovo = Arrays.asList("1");
        List<String> pOhrid = Arrays.asList("1");
        List<String> pBitola = Arrays.asList("1");
        List<String> pGevgelija = Arrays.asList("1");
        List<String> pGostivar = Arrays.asList("1");
        List<String> pVeles = Arrays.asList("1");
        List<String> pStip = Arrays.asList("1");
        List<String> pPrilep = Arrays.asList("1");
        List<String> lista = Arrays.asList();

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

        if(grad.equals("Скопје")) {
            lista = pSkopje;
        }
        if(grad.equals("Куманово")) {
            lista = pKumanovo;
        }
        if(grad.equals("Тетово")) {
            lista = pTetovo;
        }
        if(grad.equals("Охрид")) {
            lista = pOhrid;
        }
        if(grad.equals("Битола")) {
            lista = pBitola;
        }
        if(grad.equals("Гевгелија")) {
            lista = pGevgelija;
        }
        if(grad.equals("Гостивар")) {
            lista = pGostivar;
        }
        if(grad.equals("Велес")) {
            lista = pVeles;
        }
        if(grad.equals("Штип")) {
            lista = pStip;
        }
        if(grad.equals("Прилеп")) {
            lista = pPrilep;
        }

        myRecyclerView = (RecyclerView) findViewById(R.id.placesRview);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new ParkingPlacesAdapter(lista, R.layout.parking_places_layout, this);
        myRecyclerView.setAdapter(adapter);
    }
}
