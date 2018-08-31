package com.peruzal.flicks.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.peruzal.flicks.R;
import com.peruzal.flicks.adapters.MoviesPagesAdapter;
import com.peruzal.flicks.fragments.FavoriteMoviesFragment;
import com.peruzal.flicks.fragments.NowShowingMoviesFragment;
import com.peruzal.flicks.fragments.PopularMoviesFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    MoviesPagesAdapter pagesAdapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PopularMoviesFragment());
        fragmentList.add(new NowShowingMoviesFragment());
        fragmentList.add(new FavoriteMoviesFragment());

        List<CharSequence> pageTitles = new ArrayList<>();
        pageTitles.add("Popular");
        pageTitles.add("Now Showing");
        pageTitles.add("Favorite");

        pagesAdapter = new MoviesPagesAdapter(getSupportFragmentManager(), fragmentList, pageTitles);
        viewPager.setAdapter(pagesAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
