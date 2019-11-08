package com.kevinmhaube.esportscalendar.PandaScoreAPI;

import com.kevinmhaube.esportscalendar.PandaScoreModel.Tournament;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PandaScoreTournamentAPI {

    @GET("{game}/tournaments/upcoming")
    Call<List<Tournament>> getGameTournaments(
            @Path("game") String game,
            @Query("token") String api_key
    );

    @GET("tournaments/upcoming")
    Call<List<Tournament>> getAllTournaments(
            @Query("token") String api_key
    );

}
