package com.meag.reciclerviewcomidas;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    ArrayList<Food> foods;


    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return (new FoodViewHolder(v));
    }

    @Override
    public void onBindViewHolder(FoodAdapter.FoodViewHolder holder, final int position) {
        holder.name.setText(foods.get(position).getName());
        holder.img.setImageResource(foods.get(position).getImg());
        //COLOCAR LA IMAGEN CORRESPONDIENT DEPENDIENDO DE SI ESTA O NO COMO FAVORITO
        if(foods.get(position).getbFav()) {
            holder.star.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else{
            holder.star.setImageResource(android.R.drawable.btn_star_big_off);
        }

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    public  class FoodViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name;
        ImageView img;
        ImageButton star;

        public FoodViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
            // CODIGO PARA MANEJAR LOS CLICKS EN LA ESTRELLA Y CAMBIAR EL RESOURCE
            star = itemView.findViewById(R.id.imgb);




            star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!foods.get(getAdapterPosition()).getbFav()){
                        foods.get(getAdapterPosition()).setbFav(true);

                        star.setImageResource(android.R.drawable.btn_star_big_on);
                        Log.d("BOOL", "onClick: CAMBIO EL BOOL A TRUE");
                    }
                    else{
                        foods.get(getAdapterPosition()).setbFav(false);
                        star.setImageResource(android.R.drawable.btn_star_big_off);
                        Log.d("BOOL", "onClick: CAMBIO EL BOOL A FALSE");
                    }
                }
            });
        }
    }

    public FoodAdapter(ArrayList<Food> foods){
        this.foods=foods;
    }
}
