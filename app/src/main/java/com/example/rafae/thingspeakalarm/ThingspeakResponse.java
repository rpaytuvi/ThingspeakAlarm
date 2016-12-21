package com.example.rafae.thingspeakalarm;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by rafae on 12/14/2016.
 */
public class ThingspeakResponse {

    @SerializedName("channel")
    private Channel channel;
    @SerializedName("feeds")
    private List<Feed> feeds;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }
}
