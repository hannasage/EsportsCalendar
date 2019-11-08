package com.kevinmhaube.esportscalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kevinmhaube.esportscalendar.PandaScoreModel.Tournament;
import com.squareup.picasso.Picasso;

import org.apache.commons.text.WordUtils;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private List<Tournament> mEvents;

    public EventListAdapter(List<Tournament> events) {
        mEvents = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.card_event, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tournament tournament = mEvents.get(position);
        String tName = tournament.getLeague().getName() + " - " + tournament.getSerie().getFull_name();
        //TODO: Set icon by Image_URL
        Picasso.get()
                .load(tournament.getLeague().getImage_url())
                .resize(220, 220)
                .centerInside()
                .into(holder.icon);
        holder.title.setText(WordUtils.capitalize(tournament.getLeague().getName()));
        holder.subTitle.setText(WordUtils.capitalize(tournament.getSerie().getFull_name()));
        holder.game.setText(tournament.getVideogame().getName());
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;
        TextView subTitle;
        TextView game;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.iconImageView);
            title = itemView.findViewById(R.id.titleTextView);
            subTitle = itemView.findViewById(R.id.subTitleTextView);
            game = itemView.findViewById(R.id.gameTextView);
        }

    }
}
