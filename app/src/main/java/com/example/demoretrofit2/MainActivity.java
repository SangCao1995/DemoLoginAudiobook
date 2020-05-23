package com.example.demoretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demoretrofit2.model.User;
import com.example.demoretrofit2.service.RestfulApiService;
import com.example.demoretrofit2.service.RestfulClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    EditText usernameEditText, passwordEditText;
    Button loginButton;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isLogged", false)) {
            goToListAudioBookActivity();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                User user = new User(username, password);

                Call<User> userCall = RestfulClient.getRestfulApiService().login(user);
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            User user = response.body();
                            goToListAudioBookActivity();
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isLogged", true);
                            String token = user.getToken();
                            editor.putString("token", token);
                            editor.apply();
                        }
                        else {
                            Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t + "", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void goToListAudioBookActivity() {
        Intent intent = new Intent(MainActivity.this, ListAudioBookActivity.class);
        startActivity(intent);
    }
}
