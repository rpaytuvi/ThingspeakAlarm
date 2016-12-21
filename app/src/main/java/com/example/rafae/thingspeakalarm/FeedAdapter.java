package com.example.rafae.thingspeakalarm;

/**
 * Created by ferdyrod on 12/9/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private List<Feed> feeds;
    private Context context;

    public FeedAdapter(Context context,List<Feed> feeds) {
        this.context = context;
        this.feeds = feeds;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView feedTemperature;
        TextView feedLuminosity;
        TextView feedDateHour;
        public ViewHolder(View view) {
            super(view);
            feedTemperature = (TextView)view.findViewById(R.id.temperature);
            feedLuminosity = (TextView)view.findViewById(R.id.luminosity);
            feedDateHour = (TextView)view.findViewById(R.id.date_hour);
        }
    }

    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        String temperature = String.format("%1$.2f", Double.parseDouble(feeds.get(position).getTemperature()));
        String luminosity = feeds.get(position).getLuminosity();
        String createdAt = feeds.get(position).getCreatedAt().replace('T', ' ').replace('Z', ' ').replace('-', '/');
        viewHolder.feedTemperature.setText(temperature);
        viewHolder.feedLuminosity.setText(luminosity);
        viewHolder.feedDateHour.setText(createdAt);
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public void setFeedList(List<Feed> feeds) {
        this.feeds.clear();
        this.feeds.addAll(feeds);
        notifyDataSetChanged();
    }

}
