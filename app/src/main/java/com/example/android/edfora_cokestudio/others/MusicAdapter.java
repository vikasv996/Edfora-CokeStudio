package com.example.android.edfora_cokestudio.others;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.android.edfora_cokestudio.R;

import java.util.ArrayList;

/**
 * Created by ViCkY on 20-03-2017 at 10:21 PM.
 */

public class MusicAdapter extends ArrayAdapter<MusicDetails> {


    public MusicAdapter(Activity context, ArrayList<MusicDetails> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        MusicDetails currentSong = getItem(position);

        ImageView songCoverImageView = (ImageView) listItemView.findViewById(R.id.song_cover_image_view);

        Glide.with(getContext()).load(currentSong.getSongCoverImage())
                .crossFade()
                .thumbnail(0.5f)
                //.bitmapTransform(new CircleTransform(getContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(songCoverImageView);

        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        songNameTextView.setText(currentSong.getSongName());

        TextView songArtistNameTextView = (TextView) listItemView.findViewById(R.id.song_artist_name_text_view);
        songArtistNameTextView.setText(currentSong.getSongArtist());

        return listItemView;
    }
}
