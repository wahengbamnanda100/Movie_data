package com.example.movie_data;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class movieDisply extends Fragment {

    private SQLiteDatabase database;
    private MovieAdapter adapter;

    public movieDisply() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_disply, container, false);

        movieDBHelper helper = new movieDBHelper(getContext());
        database = helper.getReadableDatabase();

        RecyclerView recyclerView = view.findViewById(R.id.tableRecyclerVIew);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MovieAdapter(getContext(), getallData());
        recyclerView.setAdapter(adapter);

        adapter.swapCursor(getallData());

        return view;
    }

    private Cursor getallData() {

        return database.query(
                MovieContract.MovieEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                MovieContract.MovieEntry.COLUMN_TIMESTAMP + "DESC"
        );
    }

}
