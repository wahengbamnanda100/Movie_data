package com.example.movie_data;

import android.provider.BaseColumns;

public class MovieContract {


    private MovieContract() {}

    public static final class MovieEntry implements BaseColumns {
        public static final String TABLE_NAME = "movieDetail";
        public static final String COLUMN_MOVIE_NAME = "movieName";
        public static final String COLUMN_MOVIE_LANGUAGE = "movieLanguage";
        public static final String COLUMN_MOVIE_GENRE = "movieGenre";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
