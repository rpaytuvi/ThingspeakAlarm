package com.example.rafae.thingspeakalarm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rafae on 12/14/2016.
 */
public interface ThingspeakService {

    @GET("/channels/197223/feeds.json")
    Call<ThingspeakResponse> getFeeds(@Query("results") int numberOfResults);

}
