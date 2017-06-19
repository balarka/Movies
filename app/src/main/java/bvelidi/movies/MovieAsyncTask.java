package bvelidi.movies;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import bvelidi.movies.data.Movie;
import bvelidi.movies.utils.NetworkUtils;

/**
 * Created by bvelidi on 6/14/17.
 */

public class MovieAsyncTask extends AsyncTask<String, Void, List<Movie>> {

    private RecyclerView mRecyclerView;
    private Context mContext;

    public MovieAsyncTask(Context context, RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mContext = context;
    }

    @Override
    protected List<Movie> doInBackground(String... params) {
        return NetworkUtils.fetchMoviesBy(params[0]);
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        if(movies != null && movies.size() > 0) {
            mRecyclerView.setAdapter(new MovieAdapter(mContext, movies));
        }
    }
}
