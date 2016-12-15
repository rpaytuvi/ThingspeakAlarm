package com.example.rafae.thingspeakalarm;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafae on 12/14/2016.
 */
public class ThingspeakResponse<T> {

    @SerializedName("channel")
    private Channel channel;
    @SerializedName("feeds")
    private T feeds;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ArrayList<T> getFeeds() {
        return feeds;
    }

    public void setFeeds(ArrayList<T> feeds) {
        this.feeds = feeds;
    }
}
