package com.example.finalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import retrofit2.Response;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.finalandroid.clases.entrenador;
import com.example.finalandroid.clases.pokemon;
import com.example.finalandroid.clases.respon;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    static String url="https://upn.lumenes.tk/entrenador/{n00033222}";
    static String urls="https://upn.lumenes.tk/entrenador/{n00033222}/pokemones";
    static String urlpokemons="https://upn.lumenes.tk/pokemons/n00033222";
    public TextView Nombre;
    public TextView pueblo;
    public ImageView imas;
    public entrenador entrenadors;
    private RequestQueue requestQueue;
    JsonObjectRequest jsArrayRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        Button btnmispokemons= findViewById(R.id.btnVerPokemons);
        Log.i("data","falsa");
        btnmispokemons.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent;

                intent = new Intent(getApplicationContext(), listaPokemons.class);
                startActivity(intent);
            }
        });
        Button btnCapturarPokemon= findViewById(R.id.btnCPokemon);
        btnCapturarPokemon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent;

                intent = new Intent(getApplicationContext(), addPokemon.class);
                startActivity(intent);
            }
        });
        //Button fab = findViewById(R.id.AgregarMaestroBtn);
       // PetitionGet();
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                intent = new Intent(getApplicationContext(), EntrenadorPokemonActivity.class);

                intent.putExtra("nombres",entrenadors.nombres);
                intent.putExtra("pueblo",entrenadors.pueblo);
                startActivity(intent);


            }
        });*/
    }
    List<entrenador> items;

   public void AdapterSet(entrenador entrenadors){
         AppCompatActivity EntrenadorPokemonActiv = new AppCompatActivity();

         Intent intent = new Intent(this, EntrenadorPokemonActivity.class);
          startActivity(intent);
    }
}