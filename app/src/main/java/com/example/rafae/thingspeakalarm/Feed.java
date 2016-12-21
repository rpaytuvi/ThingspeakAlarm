package com.example.rafae.thingspeakalarm;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rafae on 12/14/2016.
 */
public class Feed {

    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("entryId")
    private Integer entryId;
    @SerializedName("field1")
    private String temperature;
    @SerializedName("field2")
    private String luminosity;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(String luminosity) {
        this.luminosity = luminosity;
    }
}
