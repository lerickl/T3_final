package com.example.finalandroid.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalandroid.DetallePokemon;
import com.example.finalandroid.R;
import com.example.finalandroid.clases.pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPokemon extends RecyclerView.Adapter<AdapterPokemon.PokemonViewHolder> {
        List<pokemon> data;
        View view;
        public AdapterPokemon(List<pokemon> data)
        {
                this.data = data;
        }
        @NonNull
        @Override
        public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                //LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);

                //PokemonViewHolder pokemonViewHolder = new PokemonViewHolder(view);

                return new PokemonViewHolder(view);
                }

        @Override
        public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {

                TextView Titulo = holder.itemView.findViewById(R.id.tipoPokemon);
                TextView nombre = holder.itemView.findViewById(R.id.NombrePokemon);
                //ImageView Imagen = holder.itemView.findViewById(R.id.profile_image);

                pokemon pokemons = data.get(position);

                Titulo.setText(pokemons.tipo);
                nombre.setText(pokemons.nombre);
                Picasso.get()
                        .load(pokemons.url_imagen)
                        .into((ImageView) holder.itemView.findViewById(R.id.profile_image));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Context context = view.getContext();

                                Intent intent = new Intent(context, DetallePokemon.class);

                                intent.putExtra("ID",pokemons.id);
                                intent.putExtra("nombre",pokemons.nombre);
                                intent.putExtra("tipo",pokemons.tipo);
                                intent.putExtra("url",pokemons.url_imagen);

                                context.startActivity(intent);
                                Log.e("Clic","CAR"+ pokemons.id);
                        }
                });

               // DetallePokemon(position);
                }
        @Override
        public int getItemCount() {
                return data.size();
                }

        public static class PokemonViewHolder extends RecyclerView.ViewHolder{

            public PokemonViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
            public void DetallePokemon(final int pos){

                    view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();

                        pokemon pokemons = data.get(pos);
                        Intent intent = new Intent(context, DetallePokemon.class);

                        intent.putExtra("ID",pokemons.id);

                        context.startActivity(intent);
                        Log.e("Clic","CAR"+ pokemons.id);

                    }
                });
            }


}
