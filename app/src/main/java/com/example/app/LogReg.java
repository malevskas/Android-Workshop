package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class LogReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logreg);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        /*final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView img = (ImageView) findViewById(R.id.city);
                Toast toast = Toast.makeText(getApplicationContext(),"Вие избравте: " + spinner.getSelectedItem(), Toast.LENGTH_SHORT);
                toast.show();
                if (spinner.getSelectedItem().equals("Берлин")) {
                    img.setImageResource(R.drawable.berlin);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast toast = Toast.makeText(getApplicationContext(),"Не избравте ништо", Toast.LENGTH_SHORT);
                toast.show();
            }
        });*/
    }

    public void login(View view) {
        Intent intent = new Intent(this, Cities.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, Cities.class);
        startActivity(intent);
    }

}