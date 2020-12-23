package com.example.app;

import android.content.Context;
import android.content.Intent;
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public TextView free;
        public TextView taken;
        public Button button;
        public TextView grad;
        public TextView datum;
        public TextView vreme;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.parking);
            button = (Button) itemView.findViewById(R.id.nextButton);
            free = (TextView) itemView.findViewById(R.id.free);
            taken = (TextView) itemView.findViewById(R.id.taken);
            grad = (TextView) itemView.findViewById(R.id.grad);
            datum = (TextView) itemView.findViewById(R.id.datum);
            vreme = (TextView) itemView.findViewById(R.id.vreme);
        }
    }

    public ParkingPlacesAdapter(List<String> myList, int parkingLayout, Context myContext) {
        this.myList = myList;
        this.parkingLayout = parkingLayout;
        this.myContext = myContext;
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
                Intent intent = new Intent(v.getContext(), ReservationConfirmation.class);
                intent.putExtra("grad", viewHolder.grad.getText().toString());
                intent.putExtra("datum", viewHolder.datum.getText().toString());
                intent.putExtra("vreme", viewHolder.vreme.getText().toString());
                intent.putExtra("parking", viewHolder.text.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }


}
