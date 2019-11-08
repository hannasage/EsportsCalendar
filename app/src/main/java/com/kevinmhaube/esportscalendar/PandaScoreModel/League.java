package com.kevinmhaube.esportscalendar.PandaScoreModel;

public class League {

    int id;
    String image_url;
    boolean live_supported;
    String modified_at;
    String name;
    String slug;
    String url;

    public int getId() {
        return id;
    }

    public String getImage_url() {
        return image_url;
    }

    public boolean isLive_supported() {
        return live_supported;
    }

    public String getModified_at() {
        return modified_at;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getUrl() {
        return url;
    }
}
