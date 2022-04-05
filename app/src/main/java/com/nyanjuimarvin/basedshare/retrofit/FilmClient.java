package com.nyanjuimarvin.basedshare.retrofit;

import static com.nyanjuimarvin.basedshare.constants.Constants.MOVIE_DB_BASE_URL;
import static com.nyanjuimarvin.basedshare.constants.Constants.MOVIE_DB_KEY;

import com.nyanjuimarvin.basedshare.endpoints.FilmEndpoint;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmClient {

    public static Retrofit retrofit = null;

    public static FilmEndpoint getFilmClient(){
        if(retrofit == null){
            //Interceptor
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request request = chain.request()
                                .newBuilder()
                                .build();
                        return chain.proceed(request);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(MOVIE_DB_BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(FilmEndpoint.class);
    }
}
