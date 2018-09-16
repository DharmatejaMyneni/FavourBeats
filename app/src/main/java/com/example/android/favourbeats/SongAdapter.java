package com.example.android.favourbeats;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.favourbeats.model.Song;

import java.util.ArrayList;

/**
 * Created by dharm on 17-07-2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

       static class ViewHolder {
        private TextView songTextView;
        private TextView artistTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song currentSong = getItem(position);

        ViewHolder holder;


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
            holder = new ViewHolder();
            // Finds Song,and Artist TextViews
            holder.songTextView = (TextView) convertView.findViewById(R.id.song_text_view);
            holder.artistTextView = (TextView) convertView.findViewById(R.id.artist_text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Sets the text to current Song object
        holder.songTextView.setText(currentSong.getSong());


        // Sets the text to current Artist object
        holder.artistTextView.setText(currentSong.getArtist());
        // End reference

        // Return the whole list_item layout
        return convertView;
    }
}
