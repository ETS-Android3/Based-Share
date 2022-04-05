package com.nyanjuimarvin.basedshare.endpoints;

import com.nyanjuimarvin.basedshare.models.film.FilmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmEndpoint {

    @GET("search/multi")
    Call<FilmResponse> getFilms(
            @Query("query") String query,
            @Query("api_key")String key);
}
