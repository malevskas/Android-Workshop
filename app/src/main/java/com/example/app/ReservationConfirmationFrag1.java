package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReservationConfirmationFrag1  extends Fragment {

    Button nav;

    public ReservationConfirmationFrag1() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.res_conf_frag1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Intent intent = getActivity().getIntent();
        String grad = intent.getStringExtra("grad");
        TextView gradot = (TextView) getActivity().findViewById(R.id.grad);
        gradot.setText(grad);
        String datum = intent.getStringExtra("datum");
        TextView datumot = (TextView) getActivity().findViewById(R.id.datum);
        datumot.setText(datum);
        String vreme = intent.getStringExtra("vreme");
        TextView vremeto = (TextView) getActivity().findViewById(R.id.vreme);
        vremeto.setText(vreme);
        String lokacija = intent.getStringExtra("lokacija");
        TextView lokacijata = (TextView) getActivity().findViewById(R.id.lokacija);
        lokacijata.setText(lokacija);

        nav = (Button) getActivity().findViewById(R.id.nav);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Maps.class);
                intent.putExtra("grad", grad);
                intent.putExtra("lokacija", lokacija);
                v.getContext().startActivity(intent);
            }
        });
    }

    /*public void navigate(View view) {
        Intent intent = new Intent(this, Maps.class);
        intent.putExtra("grad", grad);
        intent.putExtra("lokacija", lokacija);
        startActivity(intent);
    }*/

}
