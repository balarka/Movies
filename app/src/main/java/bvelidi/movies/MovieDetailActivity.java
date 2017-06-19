package bvelidi.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bvelidi.movies.data.Movie;
import bvelidi.movies.utils.NetworkUtils;

public class MovieDetailActivity extends AppCompatActivity {

    private TextView mTextView;
    private ImageView mImageView;
    private TextView mDescrView;
    private TextView mRating;
    private TextView mReleaseDate;
    private final String PARCELABLE_MOVIE_KEY = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        getSupportActionBar().setTitle(getString(R.string.movie_detail));
        Intent intent = getIntent();
        Movie movie = intent.getExtras().getParcelable(PARCELABLE_MOVIE_KEY);

        mTextView = (TextView) findViewById(R.id.movie_title);
        mTextView.setText(movie.getOriginal_title());

        mDescrView = (TextView) findViewById(R.id.description);
        mDescrView.setText(movie.getOverview());

        mRating = (TextView) findViewById(R.id.rating);
        mRating.setText(movie.getVote_average()+ getString(R.string.movie_rating_suffix));

        mReleaseDate = (TextView) findViewById(R.id.release_date);
        mReleaseDate.setText(getString(R.string.release_date_label) + " "+ movie.getRelease_date());

        mImageView = (ImageView) findViewById(R.id.movie_img);
        String url = NetworkUtils.BASE_IMAGE_URL + movie.getPoster_path();
        Picasso.with(this).load(url).into(mImageView);
    }
}
