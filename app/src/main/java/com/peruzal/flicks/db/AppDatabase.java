package com.peruzal.flicks.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.peruzal.flicks.converters.ImageConverter;
import com.peruzal.flicks.converters.ListConverter;
import com.peruzal.flicks.dao.MovieDao;
import com.peruzal.flicks.models.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
@TypeConverters(value = {ImageConverter.class, ListConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}
