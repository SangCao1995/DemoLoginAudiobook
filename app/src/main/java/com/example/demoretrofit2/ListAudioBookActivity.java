package com.example.demoretrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoretrofit2.adapter.AudioBookAdapter;
import com.example.demoretrofit2.model.AudioBook;
import com.example.demoretrofit2.model.ListAudioBook;
import com.example.demoretrofit2.model.User;
import com.example.demoretrofit2.service.RestfulClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAudioBookActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    SharedPreferences sharedPreferences;
    ArrayList<AudioBook> audioBooks;
    AudioBookAdapter audioBookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_audio_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListAudioBookActivity.this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");

        Call<ListAudioBook> listAudioBookCall = RestfulClient.getRestfulApiService().getAudioBooks(token);
        listAudioBookCall.enqueue(new Callback<ListAudioBook>() {
            @Override
            public void onResponse(Call<ListAudioBook> call, Response<ListAudioBook> response) {
                if (response.isSuccessful()) {
                    ListAudioBook listAudioBook = response.body();
                    audioBooks = new ArrayList<>();
                    audioBooks = listAudioBook.getAudioBooks();

                    audioBookAdapter = new AudioBookAdapter(ListAudioBookActivity.this, audioBooks);
                    recyclerView.setAdapter(audioBookAdapter);
                }
                else {
                    Toast.makeText(ListAudioBookActivity.this, response.code() + "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListAudioBook> call, Throwable t) {
                Toast.makeText(ListAudioBookActivity.this, t + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
