package bvelidi.movies.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bvelidi on 6/14/17.
 */

public class Movie implements Parcelable{
    private int vote_count;
    private int id;
    private boolean video;

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getVote_average() {
        return vote_average;
    }

    private float vote_average;
    private String title;
    private float popularity;
    private String poster_path;
    private String original_language;
    private String original_title;
    private int[] genre_ids;
    private String backdrop_path;
    private boolean adult;
    private String overview;
    private String release_date;

    public Movie(int vote_count, int id, boolean video, int vote_average, String title, float popularity, String poster_path, String original_language, String original_title, int[] genre_ids, String backdrop_path, boolean adult, String overview, String release_date) {
        this.vote_count = vote_count;
        this.id = id;
        this.video = video;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.genre_ids = genre_ids;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
    }

    public Movie(Parcel in) {
        this.title = in.readString();
        this.original_title = in.readString();
        this.vote_count = in.readInt();
        this.poster_path = in.readString();
        this.overview = in.readString();
        this.vote_average = in.readFloat();
        this.release_date = in.readString();
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(original_title);
        dest.writeInt(vote_count);
        dest.writeString(poster_path);
        dest.writeString(overview);
        dest.writeFloat(vote_average);
        dest.writeString(release_date);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[0];
        }
    };
}
