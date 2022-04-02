package com.nyanjuimarvin.basedshare.retrofit;

import static com.nyanjuimarvin.basedshare.constants.Constants.SPOTIFY_BASE_URL;

import com.nyanjuimarvin.basedshare.endpoints.MusicEndpoint;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicClient {
    private static Retrofit retrofit = null;

    public static MusicEndpoint getApiClient(){
        if(retrofit == null){

            //OkHttp for Error Handling
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor(){

                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request myRequest = chain.request().newBuilder()
                                    .build();
                            return chain.proceed(myRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(SPOTIFY_BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(MusicEndpoint.class);
    }
}
