package com.peruzal.flicks.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peruzal.flicks.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowShowingMoviesFragment extends Fragment {


    public NowShowingMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_now_showing_movies, container, false);
    }

}
