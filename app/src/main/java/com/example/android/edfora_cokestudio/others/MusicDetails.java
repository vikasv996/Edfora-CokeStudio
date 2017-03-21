package com.example.android.edfora_cokestudio.others;

/**
 * Created by ViCkY on 20-03-2017 at 10:12 PM.
 */

public class MusicDetails {

    private String mSongName;
    private String mSongUrl;
    private String mSongArtist;
    private String mSongCoverImage;

    public MusicDetails(String songName, String songUrl, String songArtist, String songCoverImage) {
        mSongName = songName;
        mSongUrl = songUrl;
        mSongArtist = songArtist;
        mSongCoverImage = songCoverImage;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getSongUrl() {
        return mSongUrl;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongCoverImage() {
        return mSongCoverImage;
    }
}
