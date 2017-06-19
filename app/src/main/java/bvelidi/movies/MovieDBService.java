package bvelidi.movies;

import java.util.List;
import java.util.Map;

import bvelidi.movies.data.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by bvelidi on 6/14/17.
 */

public interface MovieDBService {
    @GET("movie/popular")
    Call<MovieResponse> listPopular(@QueryMap Map<String, String> options);

    @GET("movie/top_rated")
    Call<MovieResponse> listTopRated(@QueryMap Map<String, String> options);
}