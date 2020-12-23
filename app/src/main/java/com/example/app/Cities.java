package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class Cities extends AppCompatActivity {

    RecyclerView myRecyclerView;
    CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        List<String> gradovi = Arrays.asList("Скопје", "Куманово", "Тетово", "Охрид", "Битола", "Гевгелија",
                "Гостивар", "Велес", "Штип", "Прилеп");

        myRecyclerView = (RecyclerView) findViewById(R.id.rView);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CityAdapter(gradovi, R.layout.cities_layout, this);
        myRecyclerView.setAdapter(adapter);
    }
}