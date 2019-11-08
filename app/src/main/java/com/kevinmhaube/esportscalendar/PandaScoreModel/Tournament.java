package com.kevinmhaube.esportscalendar.PandaScoreModel;

import java.util.List;

public class Tournament {

    String begin_at;
    String end_at;
    int id;
    League league;
    /*
        id
        image_url
        live_supported
        modified_at
        name
        slug
        url
     */
    String modified_at;
    String name;
    Serie serie;
    /*
        begin_at
        description
        end_at
        full_name
     */
    String slug;
    List<Team> teams;
    /*
        acronym
        image_url
        name
        slug
     */
    VideoGame videogame;

    public String getBegin_at() {
        return begin_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public int getId() {
        return id;
    }

    public League getLeague() {
        return league;
    }

    public String getModified_at() {
        return modified_at;
    }

    public String getName() {
        return name;
    }

    public Serie getSerie() {
        return serie;
    }

    public String getSlug() {
        return slug;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public VideoGame getVideogame() {
        return videogame;
    }
}
