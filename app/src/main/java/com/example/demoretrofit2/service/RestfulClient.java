package com.example.demoretrofit2.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestfulClient {
    private final static String BASE_URL = "https://sbookau.herokuapp.com/v1/";
    private static RestfulApiService restfulApiService;

    static {
        configRetrofit();
    }

    private static void configRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restfulApiService = retrofit.create(RestfulApiService.class);
    }

    public static RestfulApiService getRestfulApiService() {
        return restfulApiService;
    }
}
