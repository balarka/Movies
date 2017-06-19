package bvelidi.movies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AsyncTask at;
    private final String SAVE_INSTANCE_STATE_CRITERIA = "criteria";
    private String criteria = "popular";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movies);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        if(savedInstanceState != null) {
            if(savedInstanceState.containsKey(SAVE_INSTANCE_STATE_CRITERIA)) {
                criteria = savedInstanceState.getString(SAVE_INSTANCE_STATE_CRITERIA);
            }
        }
        at = new MovieAsyncTask(getApplicationContext(), mRecyclerView).execute(criteria);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVE_INSTANCE_STATE_CRITERIA, criteria);
    }

    @Override
    protected void onPause() {
        at.cancel(true);
        super.onPause();
        System.out.println("transigion from onPause");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("transigion from onDestroy");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int actionId = item.getItemId();
        if(actionId == R.id.sort_by_popular) {
            criteria = "popular";
            this.getSupportActionBar().setTitle(getString(R.string.popular_movies_title));
        } else if (actionId == R.id.sort_by_rating) {
            criteria = "top_rated";
            this.getSupportActionBar().setTitle(getString(R.string.top_movies_title));
        } else {
            throw new IllegalArgumentException("Unknown menu click item");
        }
        at = new MovieAsyncTask(getApplicationContext(), mRecyclerView).execute(criteria);
        return super.onOptionsItemSelected(item);
    }
}
