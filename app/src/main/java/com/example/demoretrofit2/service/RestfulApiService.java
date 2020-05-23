package com.example.demoretrofit2.service;

import androidx.annotation.Nullable;

import com.example.demoretrofit2.model.AudioBook;
import com.example.demoretrofit2.model.ListAudioBook;
import com.example.demoretrofit2.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestfulApiService {
    @POST("login")
    Call<User> login(@Body User user);

    @GET("auth/books")
    Call<ListAudioBook> getAudioBooks(@Header("x-access-token") String token);
    //@Query("filter") String sFilter, @Query("q") String q, @Query("page") int page, @Query("perPage") int perPage
}
