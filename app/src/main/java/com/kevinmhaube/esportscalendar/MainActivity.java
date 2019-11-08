package com.kevinmhaube.esportscalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import com.kevinmhaube.esportscalendar.PandaScoreAPI.PandaScoreTournamentAPI;
import com.kevinmhaube.esportscalendar.PandaScoreModel.Tournament;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "https://api.pandascore.co/";

    RecyclerView mRecyclerView;
    private List<Tournament> mEvents;
    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date date = new Date();
        mCalendarView = findViewById(R.id.calendarView2);
        mRecyclerView = findViewById(R.id.eventRecycler);

        mCalendarView.setMinDate(date.getTime());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PandaScoreTournamentAPI tournamentAPI = builder.create(PandaScoreTournamentAPI.class);

        //TODO: Call for Tournaments based on Game/Teams selected by user in Settings

        getAllTournaments(tournamentAPI);
    }

    private void getAllTournaments(PandaScoreTournamentAPI tournamentAPI) {
        Call<List<Tournament>> call = tournamentAPI.getAllTournaments(getString(R.string.API_KEY));
        call.enqueue(new Callback<List<Tournament>>() {
            @Override
            public void onResponse(Call<List<Tournament>> call, final Response<List<Tournament>> response) {

                if(!response.isSuccessful()) {
                    Log.d(TAG, "Code: " + response.code());
                    return;
                }
                //TODO: Handle response.body()
                mEvents = response.body();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        EventListAdapter adapter = new EventListAdapter(response.body());
                        mRecyclerView.setAdapter(adapter);
                        mCalendarView.setMaxDate(Instant.parse(mEvents.get(mEvents.size()-1).getBegin_at())
                                .toEpochMilli());
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Tournament>> call, Throwable t) {
                Log.d(TAG, "Oh no, something bad happened: " + t.getMessage());
            }
        });
    }

    private void getGameTournaments(String game, PandaScoreTournamentAPI tournamentAPI) {
        Call<List<Tournament>> call = tournamentAPI.getGameTournaments(game, getString(R.string.API_KEY));
        call.enqueue(new Callback<List<Tournament>>() {
            @Override
            public void onResponse(Call<List<Tournament>> call, Response<List<Tournament>> response) {

                if(!response.isSuccessful()) {
                    Log.d(TAG, "Code: " + response.code());
                    return;
                }

                //TODO: Handle response.body()
            }

            @Override
            public void onFailure(Call<List<Tournament>> call, Throwable t) {
                Log.d(TAG, "Oh no, something bad happened: " + t.getMessage());
            }
        });
    }

}
