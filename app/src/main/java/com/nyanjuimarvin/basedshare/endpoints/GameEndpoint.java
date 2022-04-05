package com.nyanjuimarvin.basedshare.endpoints;

import com.nyanjuimarvin.basedshare.models.game.GamesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GameEndpoint {
    @GET("games")
    Call<GamesResponse> getGames(@Query("key") String authHead, @Query("search")String search);
}
