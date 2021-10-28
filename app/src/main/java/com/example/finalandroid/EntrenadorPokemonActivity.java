package com.example.finalandroid;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalandroid.clases.entrenador;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class EntrenadorPokemonActivity extends AppCompatActivity {
    private ImageView imagen;
    public String url="https://upn.lumenes.tk/entrenador/{n00033222}";

    static final int REQUEST_IMAGE_CATURA = 20;
    static final int REQUEST_IMAGE_SUBIR = 10;
    public TextView Nombre;
    public TextView pueblo;
    public ImageView imas;
    public Button Btn1;
    public Button Btn2;
    public Button Btn3;
    public  entrenador entrenador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenador_pokemon);


        Btn1 = findViewById(R.id.button_CrearPokemon);
        Btn2 = findViewById(R.id.buttonVerPokemons);
        Btn3 = findViewById(R.id.buttonVer_Poke_capturados);
        Nombre = findViewById(R.id.TextNombreM);
        pueblo = findViewById(R.id.PuebloM);
        imas = findViewById(R.id.imageViewEnt);
        //ImagenClic();
       // PeticionGet();
        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("nombres");
        String dato1=bundle.getString("pueblo");
        Nombre.setText(dato);
        pueblo.setText(dato1);
        Log.e("Entrenador",dato);
        botones();


    }

    public void botones(){
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("Clic","addpokemons");
                Intent intent = new Intent(getApplicationContext(),addPokemon.class);
                startActivity(intent);
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("Clic","Imagen");
                Intent intent = new Intent(getApplicationContext(),listaPokemons.class);
                startActivity(intent);
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("Clic","Imagen");
                 Intent intent = new Intent(getApplicationContext(),listaPokemons.class);
                 startActivity(intent);
            }
        });
    }

}
