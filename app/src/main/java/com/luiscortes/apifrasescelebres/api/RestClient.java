package com.luiscortes.apifrasescelebres.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static final String BASE_URL = "http://192.168.50.112:8080/";

    private static IApiService instance;

    private RestClient() { }

    public synchronized static IApiService getInstance(){
        if (instance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retrofit.create(IApiService.class);
        }
        return instance;
    }
}
