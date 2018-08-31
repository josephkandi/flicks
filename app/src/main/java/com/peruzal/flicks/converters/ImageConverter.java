package com.peruzal.flicks.converters;

import android.arch.persistence.room.TypeConverter;

import com.peruzal.flicks.models.Image;

public class ImageConverter {
    @TypeConverter
    public  static String imageToString(Image image){
        return  image.url;
    }

    @TypeConverter
    public static Image stringToImage(String url){
        Image img = new Image();
        img.url = url;
        return img;
    }
}
