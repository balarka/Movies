package bvelidi.movies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bvelidi.movies.data.Movie;
import bvelidi.movies.utils.NetworkUtils;

/**
 * Created by bvelidi on 6/14/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    public static List<Movie> mMovieList;
    private int page = 1;
    Context mContext;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.mMovieList = movies;
        this.mContext = context;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_holder_item, parent, false);
        MovieHolder mh = new MovieHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        String url = NetworkUtils.BASE_IMAGE_URL + mMovieList.get(position).getPoster_path();
        Picasso.with(mContext).load(url).into(holder.mMoviePoster);
        if(position == this.mMovieList.size() -1) {
            ++page;
        }
    }

    @Override
    public int getItemCount() {
        return this.mMovieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mMoviePoster;
        public MovieHolder(View itemView) {
            super(itemView);

            mMoviePoster = (ImageView) itemView.findViewById(R.id.mv_image);
            mMoviePoster.setClickable(true);
            mMoviePoster.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(mContext, MovieDetailActivity.class);
            intent.putExtra("movie", mMovieList.get(position));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }
}

