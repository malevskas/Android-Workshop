package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParkingPlacesAdapter extends RecyclerView.Adapter<ParkingPlacesAdapter.ViewHolder> {

    private List<String> myList;
    private int parkingLayout;
    private Context myContext;
    private String grad;
    private String datum;
    private String vreme;
    private DBHelper db;
    private String username;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public TextView free;
        public TextView taken;
        public Button button;
        public TextView error;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.parking);
            button = (Button) itemView.findViewById(R.id.nextButton);
            free = (TextView) itemView.findViewById(R.id.free);
            taken = (TextView) itemView.findViewById(R.id.taken);
            error = (TextView) itemView.findViewById(R.id.error);
            error.setVisibility(View.INVISIBLE);
        }
    }

    public ParkingPlacesAdapter(List<String> myList, int parkingLayout, Context myContext, String grad, String datum, String vreme) {
        this.myList = myList;
        this.parkingLayout = parkingLayout;
        this.myContext = myContext;
        this.grad = grad;
        this.datum = datum;
        this.vreme = vreme;
    }

    @Override
    public ParkingPlacesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(parkingLayout, viewGroup, false);
        return new ParkingPlacesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ParkingPlacesAdapter.ViewHolder viewHolder, int i) {
        String entry = myList.get(i);
        viewHolder.text.setText(entry);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(myContext);
                String username = prefs.getString("username", "null");
                db = new DBHelper(myContext);
                boolean check = db.addRes(username, grad, datum, vreme, viewHolder.text.getText().toString());
                if(check) {
                    Intent intent = new Intent(myContext, ReservationConfirmation.class);
                    intent.putExtra("grad", grad);
                    intent.putExtra("datum", datum);
                    intent.putExtra("vreme", vreme);
                    intent.putExtra("lokacija", viewHolder.text.getText().toString());
                    myContext.startActivity(intent);
                }
                else {
                    viewHolder.error.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}
