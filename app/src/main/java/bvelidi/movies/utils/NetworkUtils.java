package bvelidi.movies.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bvelidi.movies.BuildConfig;
import bvelidi.movies.MovieDBService;
import bvelidi.movies.data.Movie;
import bvelidi.movies.data.MovieResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bvelidi on 6/14/17.
 */

public final class NetworkUtils {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/";
    private static final Map<String, String> map = new HashMap<String, String>();

    private static Map<String, String> buildDefaultAPIHeaders() {
        map.put("api_key", BuildConfig.MovieDB_API_KEY);
        return map;
    }

    private static Retrofit buildAPIClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static List<Movie> fetchMoviesBy(String criteria) {
        if (criteria == null) return null;
        MovieDBService service = buildAPIClient().create(MovieDBService.class);
        Map<String, String> headers = buildDefaultAPIHeaders();
        try {
            Call<MovieResponse> call;
            if (criteria == "top_rated") {
                call = service.listTopRated(headers);
            } else if (criteria == "popular") {
                call = service.listPopular(headers);
            } else {
                throw new UnknownError("Unknown criteria specified: "+ criteria);
            }
            Response<MovieResponse> response = call.execute();
            if(response != null && response.body() != null) {
                return response.body().getResults();
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
