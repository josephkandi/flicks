package com.peruzal.flicks;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.peruzal.flicks.adapters.MoviesAdapter;
import com.peruzal.flicks.db.AppDatabase;
import com.peruzal.flicks.models.ApiResult;
import com.peruzal.flicks.models.Movie;
import com.peruzal.flicks.viewModels.MainActivityViewModel;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityViewModel mMainActivityViewModel;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.pbLoading)
    LottieAnimationView pbLoading;
    MoviesAdapter mMoviesAdapter;
    AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDb = Room.databaseBuilder(this, AppDatabase.class, "movies.db")
                .allowMainThreadQueries()
                .build();

        ButterKnife.bind(this);

        mMainActivityViewModel = ViewModelProviders.of(this)
                                                    .get(MainActivityViewModel.class);
        mMainActivityViewModel.getMovies().observe(this, this::onMoviesChanged);
        mMainActivityViewModel.getIsBusy().observe(this, this::updateUI);

        mMoviesAdapter = new MoviesAdapter();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mMoviesAdapter);

        mMainActivityViewModel.fetchMovies();

    }

    private void updateUI(Boolean isBusy) {
        recyclerView.setVisibility(isBusy ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(isBusy ? View.VISIBLE : View.GONE);
    }

    private void onMoviesChanged(List<Movie> movies) {
        if (movies != null){
            mMoviesAdapter.setData(movies);
        }
    }
}
