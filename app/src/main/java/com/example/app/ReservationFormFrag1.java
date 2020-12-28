package com.example.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class ReservationFormFrag1 extends Fragment implements DatePickerDialog.OnDateSetListener {

    TextView date;
    TextView gradot;

    public ReservationFormFrag1() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.res_form_frag1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        date = (TextView) getActivity().findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        Intent intent = getActivity().getIntent();
        String grad = intent.getStringExtra("grad");
        gradot = (TextView) getActivity().findViewById(R.id.gradot);
        gradot.setText(grad);
    }

    private void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(
                getActivity(), this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        datePicker.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month+=1;
        String datum = dayOfMonth + "/" + month + "/" + year;
        date.setText(datum);
    }

    /*public void nextStep(View view) {
        Intent intent = getActivity().getIntent();
        String grad = intent.getStringExtra("grad");
        intent = new Intent(getActivity(), ParkingPlaces.class);
        intent.putExtra("grad", grad);
        startActivity(intent);
    }*/

}
