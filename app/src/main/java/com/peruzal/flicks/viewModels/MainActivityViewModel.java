package com.peruzal.flicks.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.peruzal.flicks.models.ApiResult;
import com.peruzal.flicks.models.Movie;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivityViewModel extends AndroidViewModel {
    private static final String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<List<Movie>> mMovies;
    private MutableLiveData<String> mError;
    private MutableLiveData<Boolean> mIsBusy;
    private static final String URL = "https://parse.peruzal.com/parse/classes/Movie";
    RequestQueue mQueue;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        if(mMovies == null){
            mMovies = new MutableLiveData<>();
        }
        mError = new MutableLiveData<>();
        mIsBusy = new MutableLiveData<>();
        mQueue = Volley.newRequestQueue(application);
    }

    public LiveData<Boolean> getIsBusy() {
        return mIsBusy;
    }

    public LiveData<String> getError() {
        return mError;
    }

    public LiveData<List<Movie>> getMovies() {
        return mMovies;
    }

    public void fetchMovies(){
        mIsBusy.setValue(true);
        JsonObjectRequest request = new JsonObjectRequest(URL,null, this::onResponse, this::onError){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                super.getHeaders();
                HashMap<String, String> headers = new HashMap<>();
                headers.put("X-Parse-Application-Id", "3DB3D11F5C93E6D0B16E723F0F7584BBF88B69E32E468D6AD763CD487A19BA9D");
                return headers;
            }
        };

        mQueue.add(request);
    }

    private void onError(VolleyError volleyError) {
        mIsBusy.setValue(false);
        if (volleyError != null){
            Log.d(TAG, volleyError.getMessage());
        }
    }

    private void onResponse(JSONObject jsonObject) {
        mIsBusy.setValue(false);
        ApiResult apiResult = new Gson().fromJson(jsonObject.toString(), ApiResult.class);
        mMovies.setValue(apiResult.movies);
    }
}
