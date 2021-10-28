package com.example.finalandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalandroid.adaptadores.AdapterPokemon;
import com.example.finalandroid.clases.pokemon;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listaPokemons extends AppCompatActivity {
    private FloatingActionButton Agregar;
    public static RecyclerView listaPokemonVista;
    public AdapterPokemon adapterL;
    private static String url ="https://upn.lumenes.tk/pokemons/n00033222";
    static  String urlpokemons="https://upn.lumenes.tk/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_pokemon);
        listaPokemonVista=findViewById(R.id.recyclerPokemon);
        listaPokemonVista.setHasFixedSize(true);
        listaPokemonVista.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlpokemons)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);
        service.all().enqueue(new Callback<List<pokemon>>() {
            @Override
            public void onResponse(Call<List<pokemon>> call, retrofit2.Response<List<pokemon>> response) {
                Log.i("MAIN_APP", String.valueOf(response.code()));
                AdapterPokemon adapter = new AdapterPokemon(response.body());
                listaPokemonVista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<pokemon>> call, Throwable t) {
                Log.e("MAIN_APP", "No se puede establecer comunicación con el API");
                Log.e("MAIN_APP",  String.valueOf(t.toString()));
            }
        });
        //ObtenerID();
        // ClicAgregar();
        //PeticonGet();
    }


}
