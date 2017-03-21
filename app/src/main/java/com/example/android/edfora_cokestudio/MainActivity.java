package com.example.android.edfora_cokestudio;

import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.LoaderManager.LoaderCallbacks;

import com.example.android.edfora_cokestudio.others.MusicAdapter;
import com.example.android.edfora_cokestudio.others.MusicDetails;
import com.example.android.edfora_cokestudio.others.MusicLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<MusicDetails>>{

    public static final String LOG_TAG = MainActivity.class.getName();

    private static final int MUSIC_ID = 102;

    private static final String MUSIC_DETAILS_URL =
            "http://starlord.hackerearth.com/edfora/cokestudio";

    private ListView musicListView;
    private MusicAdapter mAdapter;
    private ProgressBar mProgressBar;
    private TextView mLoadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingTextView = (TextView) findViewById(R.id.empty_text_view);
        //Toast.makeText(this, "Yet to add Functionality", Toast.LENGTH_LONG).show();

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            getLoaderManager().initLoader(MUSIC_ID, null, this).forceLoad();
        } else {
            mProgressBar = (ProgressBar) findViewById(R.id.loading_spinner);
            mProgressBar.setVisibility(View.INVISIBLE);
        }

        mAdapter = new MusicAdapter(this, new ArrayList<MusicDetails>());

        musicListView = (ListView) findViewById(R.id.list);

        musicListView.setAdapter(mAdapter);


    }

    @Override
    public Loader<List<MusicDetails>> onCreateLoader(int id, Bundle args) {
        Uri baseUri = Uri.parse(MUSIC_DETAILS_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        return new MusicLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<MusicDetails>> loader, List<MusicDetails> data) {
        Log.v("MainActivity", "The UI is created via onLoadFinished");

        mProgressBar = (ProgressBar) findViewById(R.id.loading_spinner);
        mProgressBar.setVisibility(View.GONE);

        mLoadingTextView = (TextView) findViewById(R.id.empty_text_view);
        mLoadingTextView.setVisibility(View.GONE);
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<MusicDetails>> loader) {
        Log.v("MainActivity", "The data is destroyed and the Loader is reset via onLoadReset()");
        //Loader reset, so we can clear out all the existing data
        mAdapter.clear();
    }
}
