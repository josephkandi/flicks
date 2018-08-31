package com.peruzal.flicks.converters;

import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListConverter {
    @TypeConverter
    public static String listToString(List<String> genre){
        String str = null;
        for (String s: genre) {
            str += s + ",";
        }
        return str;
    }

    @TypeConverter
    public static List<String> stringToList(String genre){
        return new ArrayList<String>(Arrays.asList(genre.split(",")));
    }
}
