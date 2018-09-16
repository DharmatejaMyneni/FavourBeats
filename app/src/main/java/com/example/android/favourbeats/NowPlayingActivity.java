package com.example.android.favourbeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.favourbeats.MainActivity.KEY_ARTIST;
import static com.example.android.favourbeats.MainActivity.KEY_SONG;

/**
 * Created by dharm on 17-07-2018.
 */

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        String playingSong = "";
        String playingArtist = "";
        String playingAlbum = "";

        // Gets intent and ListView item data from MainActivity
        Intent intent = getIntent();
        if (null != intent) {
            playingSong = intent.getStringExtra(KEY_SONG);
            playingArtist = intent.getStringExtra(KEY_ARTIST);
        }

        // Sets data to Their TextViews
        TextView playingSongText = (TextView) findViewById(R.id.song_name);
        playingSongText.setText(playingSong);


        TextView playingArtistText = (TextView) findViewById(R.id.artist);
        playingArtistText.setText(playingArtist);

        final ImageView playButton = (ImageView) findViewById(R.id.play_arrow);

        playButton.setTag(1);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playButton.getTag().equals(1)) {
                    playButton.setImageResource(R.drawable.ic_pause_black_24dp);
                    playButton.setTag(2);
                } else {
                    playButton.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    playButton.setTag(1);
                }

            }
        });
        //End
    }
}
