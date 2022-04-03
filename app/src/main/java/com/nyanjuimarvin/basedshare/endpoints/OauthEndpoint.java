package com.nyanjuimarvin.basedshare.endpoints;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OauthEndpoint {
    @GET("authorize")
    Call<String> getToken();
}
