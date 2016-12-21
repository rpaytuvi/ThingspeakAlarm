package com.example.rafae.thingspeakalarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<ThingspeakResponse> {

    private static final String TAG = "ThingSpeakAlarm";
    private List<Feed> feeds;
    private FeedAdapter adapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        feeds = new ArrayList<>();
        adapter = new FeedAdapter(getApplicationContext(), feeds);
        rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        callThingSpeak();

        Button buttonCallThingSpeak = (Button) findViewById(R.id.button_call_thingspeak);
        buttonCallThingSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callThingSpeak();
            }
        });
    }

    public void callThingSpeak() {
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
            ThingspeakResponse tsResponse = response.body();
            feeds = tsResponse.getFeeds();
            adapter.setFeedList(feeds);
            //adapter.notifyDataSetChanged();
            //adapter = new FeedAdapter(getApplicationContext(), feeds);
            //rv.setAdapter(adapter);
        } else {
            try {
                Log.e(TAG, "Retrofit Response: " + response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<ThingspeakResponse> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
    }
}
