package com.nyanjuimarvin.basedshare.oauth;

import static com.nyanjuimarvin.basedshare.constants.Constants.CLIENT_ID;
import static com.nyanjuimarvin.basedshare.constants.Constants.CLIENT_SECRET;
import static com.nyanjuimarvin.basedshare.constants.Constants.CONTENT_TYPE;
import static com.nyanjuimarvin.basedshare.constants.Constants.GRANT_TYPE;
import static com.nyanjuimarvin.basedshare.constants.Constants.POST_TOKEN_PATH;


import android.util.Base64;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//Client Credentials flow
public class SpotifyOauth {

    public static String token;
    private String unencodedUrl = CLIENT_ID + ":" + CLIENT_SECRET;

    //Encode URI to base64
    private String encodeUrl(){
        return Base64.encodeToString(unencodedUrl.getBytes(),Base64.URL_SAFE);
    }

    //Start another thread
    public Thread oAuthThread = new Thread(new Runnable() {
        @Override
        public void run(){
            //Http client
            OkHttpClient client = new OkHttpClient();

            //Request
            Request request = new Request.Builder()
                    .url(POST_TOKEN_PATH)
                    .header("User_Agent","OkHttp Headers.java")
                    .addHeader("Authorization", Credentials.basic(CLIENT_ID,CLIENT_SECRET))
                    .addHeader("Content-Type",CONTENT_TYPE)
                    .post(RequestBody.create(MediaType.parse(CONTENT_TYPE),"grant_type"))
                    .build();

            try(Response response = client.newCall(request).execute()){
                if (!response.isSuccessful() )throw new IOException("Unexpected code " + response);

                System.out.println(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

}
