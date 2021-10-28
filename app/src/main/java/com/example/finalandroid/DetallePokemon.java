package com.example.finalandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalandroid.clases.pokemon;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetallePokemon extends AppCompatActivity {
    private static String url = "https://upn.lumenes.tk/pokemones/{id}";
    private pokemon pokemons;
    private ImageView portada;
    private TextView nombre;
    private TextView tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_detalle);
        nombre=findViewById(R.id.NombrePokemonD);
        tipo=findViewById(R.id.tipoPokemonD);
        int id = getIntent().getIntExtra("ID",0);
        String imagen= getIntent().getStringExtra("url");
        String nombres= getIntent().getStringExtra("nombre");
        String tipos= getIntent().getStringExtra("tipo");
        Picasso.get()
                .load(imagen)
                .into((ImageView) findViewById(R.id.avatarPokemon));
        nombre.setText(nombres);
        tipo.setText(tipos);
        //DetalleLibro(id);
        //ObtenerId();
    }
    public void DetalleLibro(int id){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                Log.d("Respuesta ",response);

                pokemons = gson.fromJson(response,pokemon.class);
                LlenarDetalleLibro();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error","No hay Respuesta");
                Toast.makeText(getApplicationContext(),"Ocurrio un Error",Toast.LENGTH_SHORT).show();
            }
        }) ;
        queue.add(stringRequest);
    }
    public void LlenarDetalleLibro(){

        Picasso.get().load(pokemons.url_imagen)
                .into(portada);
        nombre.setText(pokemons.nombre);
        tipo.setText(pokemons.tipo);

    }

}
