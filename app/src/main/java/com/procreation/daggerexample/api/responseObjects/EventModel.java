package com.procreation.daggerexample.api.responseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventModel {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("title_red")
    @Expose
    private String title_red;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("startDate")
    @Expose
    private long startDate;

    @SerializedName("endDate")
    @Expose
    private long endDate;

    @SerializedName("eventLogo")
    @Expose
    private String eventLogo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle_red() {
        return title_red;
    }

    public void setTitle_red(String title_red) {
        this.title_red = title_red;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventLogo() {
        return eventLogo;
    }

    public void setEventLogo(String eventLogo) {
        this.eventLogo = eventLogo;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }
}
