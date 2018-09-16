package com.example.android.favourbeats.model;

/**
 * Created by dharm on 17-07-2018.
 */

public class Song {

    private String mSong;

    private String mArtist;

    public Song(String song, String artist) {
        mSong = song;
        mArtist = artist;
    }

    public String getSong() {
        return mSong;
    }


    public String getArtist() {
        return mArtist;
    }
}
