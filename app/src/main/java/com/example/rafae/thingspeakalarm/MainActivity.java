package com.example.rafae.thingspeakalarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<ThingspeakResponse> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thingspeak.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ThingspeakService thingspeakService = retrofit.create(ThingspeakService.class);
        Call<ThingspeakResponse> call = thingspeakService.getFeeds(15);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ThingspeakResponse> call, Response<ThingspeakResponse> response) {
        if (response.isSuccessful()) {
            ThingspeakResponse<Feeds>
        } else {

        }
    }

    @Override
    public void onFailure(Call<ThingspeakResponse> call, Throwable t) {

    }
}
