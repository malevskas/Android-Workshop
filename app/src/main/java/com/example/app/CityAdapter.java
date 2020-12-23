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

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private List<String> myList;
    private int cityLayout;
    private Context myContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;
        public Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.grad);
            image = (ImageView) itemView.findViewById(R.id.cityImg);
            button = (Button) itemView.findViewById(R.id.rezButton);
        }
    }

    public CityAdapter(List<String> myList, int cityLayout, Context myContext) {
        this.myList = myList;
        this.cityLayout = cityLayout;
        this.myContext = myContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(cityLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String entry = myList.get(i);
        viewHolder.text.setText(entry);

        if(entry.equals("Скопје")) {
            viewHolder.image.setImageResource(R.drawable.skopje);
        }
        if(entry.equals("Куманово")) {
            viewHolder.image.setImageResource(R.drawable.kumanovo);
        }
        if(entry.equals("Тетово")) {
            viewHolder.image.setImageResource(R.drawable.tetovo);
        }
        if(entry.equals("Охрид")) {
            viewHolder.image.setImageResource(R.drawable.ohrid);
        }
        if(entry.equals("Битола")) {
            viewHolder.image.setImageResource(R.drawable.bitola);
        }
        if(entry.equals("Гевгелија")) {
            viewHolder.image.setImageResource(R.drawable.gevgelija);
        }
        if(entry.equals("Гостивар")) {
            viewHolder.image.setImageResource(R.drawable.gostivar);
        }
        if(entry.equals("Велес")) {
            viewHolder.image.setImageResource(R.drawable.veles);
        }
        if(entry.equals("Штип")) {
            viewHolder.image.setImageResource(R.drawable.stip);
        }
        if(entry.equals("Прилеп")) {
            viewHolder.image.setImageResource(R.drawable.prilep);
        }

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReservationForm.class);
                intent.putExtra("grad", viewHolder.text.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}
