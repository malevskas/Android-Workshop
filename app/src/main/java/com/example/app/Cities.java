package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class Cities extends AppCompatActivity {

    RecyclerView myRecyclerView;
    CityAdapter adapter;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        db = new DBHelper(this);

        List<String> gradovi = Arrays.asList("Скопје", "Куманово", "Тетово", "Охрид", "Битола");

        myRecyclerView = (RecyclerView) findViewById(R.id.rView);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CityAdapter(gradovi, R.layout.cities_layout, this);
        myRecyclerView.setAdapter(adapter);
    }

    public void myRes(View view) {
        Intent intent = new Intent(this, MyReservations.class);
        startActivity(intent);
    }
}