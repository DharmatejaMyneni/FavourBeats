package com.example.android.favourbeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.favourbeats.model.Song;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    public static final String KEY_SONG = "KEY_SONG";
    public static final String KEY_ARTIST = "KEY_ARTIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song( "When Doves Cry", "Prince" ));
        songs.add(new Song( "I Wanna Dance With Somebody", " Whitney Houston" ));
        songs.add(new Song( "It's Gonna Be Me", "N Sync" ));
        songs.add(new Song( "Rolling in the Deep", "Adele" ));
        songs.add(new Song( "Billie Jean", " Michael Jackson" ));

        final SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.List);

        listView.setAdapter(adapter);

        // When listView item is clicked, item  is sent to new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song item = (Song) adapter.getItem(position);
                Intent nowPlaying = new Intent(getApplicationContext(), NowPlayingActivity.class);
                nowPlaying.putExtra(KEY_SONG, item.getSong());
                nowPlaying.putExtra(KEY_ARTIST, item.getArtist());
                startActivity(nowPlaying);
            }
        });





    }
}
