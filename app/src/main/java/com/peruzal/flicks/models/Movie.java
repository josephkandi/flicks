package com.peruzal.flicks.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Movie {
    @SerializedName("objectId")
    @Expose
    @PrimaryKey
    @NonNull
    public String objectId;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("createdAt")
    @Expose
    public String createdAt;
    @SerializedName("updatedAt")
    @Expose
    public String updatedAt;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("releaseYear")
    @Expose
    public String releaseYear;
    @SerializedName("genre")
    @Expose
    public List<String> genre = null;
    @SerializedName("rating")
    @Expose
    public Double rating;
    @SerializedName("description")
    @Expose
    public String description;
}