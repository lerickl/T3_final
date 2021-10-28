package com.example.finalandroid.adaptadores;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalandroid.R;
import com.example.finalandroid.clases.entrenador;

public class adapterEntrenador extends AppCompatActivity {
    entrenador entrenad;
    private View view;
    public adapterEntrenador(entrenador entrena){
        this.entrenad=entrenad;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenador_pokemon);

    }
}
