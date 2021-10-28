package com.example.finalandroid;

import com.example.finalandroid.clases.pokemon;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

public interface PokemonService {
    @GET("pokemons/n00033222")
    Call<List<pokemon>> all();

    @POST("pokemons")
    Call<pokemon> create(@Body pokemon Pokemon);

    @PUT("pokemons/{id}")
    Call<pokemon> update(@Path ("id") long id, @Body pokemon Pokemon);

}
