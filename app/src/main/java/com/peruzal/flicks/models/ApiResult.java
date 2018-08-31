package com.peruzal.flicks.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResult {
    @SerializedName("results")
    @Expose
    public List<Movie> movies = null;
}
