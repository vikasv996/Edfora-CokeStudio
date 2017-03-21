package com.example.android.edfora_cokestudio.others;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by ViCkY on 21-03-2017 at 01:39 PM.
 */

public class MusicLoader extends AsyncTaskLoader<List<MusicDetails>> {

    private String mUrl;

    public MusicLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        Log.v("PlayerLoader", "This method ensures that the background task gets executed via onStartLoading()");
        forceLoad();
    }

    @Override
    public List<MusicDetails> loadInBackground() {
        Log.v("MusicLoader", "loadInBackground() performs the network request and executes in background thread");

        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mUrl == null) {
            return null;
        }
        List<MusicDetails> music = QueryUtils.fetchPlayerDetails(mUrl);
        return music;
    }
}
