package com.example.movie_data;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class movieInput extends Fragment implements View.OnClickListener {

    private SQLiteDatabase database;

    EditText etmoviename, etlanguage, etgenre;
    Button btinsert, btclear, btshow;


    public movieInput() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_input, container, false);

        movieDBHelper helper = new movieDBHelper(getContext());
        database = helper.getWritableDatabase();


        etmoviename = view.findViewById(R.id.etmoviename);
        etlanguage = view.findViewById(R.id.etmovielang);
        etgenre = view.findViewById(R.id.etmoviegenre);

        btclear = view.findViewById(R.id.btclear);
        btinsert = view.findViewById(R.id.btsend);
        btshow = view.findViewById(R.id.btshow);

        btinsert.setOnClickListener(this);
        btclear.setOnClickListener(this);
        btshow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btsend:
                insertdata();
                break;

            case R.id.btclear:
                cleardata();
                break;

            case R.id.btshow:
                show();
                break;
        }

    }

    private void show() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new movieDisply()).commit();
    }

    private void cleardata() {
        etmoviename.setText("");
        etlanguage.setText("");
        etgenre.setText("");
    }

    private void insertdata() {
        if (etmoviename.getText().toString().trim().length() == 0 ||
                etlanguage.getText().toString().trim().length() == 0 ||
                etgenre.getText().toString().trim().length() == 0) {

            Toast.makeText(getActivity(), "Enter some details", Toast.LENGTH_LONG).show();

            return;
        }

        String name = etmoviename.getText().toString();
        String language = etlanguage.getText().toString();
        String genre = etgenre.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MovieContract.MovieEntry.COLUMN_MOVIE_NAME, name);
        contentValues.put(MovieContract.MovieEntry.COLUMN_MOVIE_LANGUAGE, language);
        contentValues.put(MovieContract.MovieEntry.COLUMN_MOVIE_GENRE, genre);

        database.insert(MovieContract.MovieEntry.TABLE_NAME, null, contentValues);

        etmoviename.getText().clear();
        etlanguage.getText().clear();
        etgenre.getText().clear();

        Toast.makeText(getActivity(), "Data Insertion Successful", Toast.LENGTH_LONG).show();

        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new movieDisply()).commit();
    }
}
