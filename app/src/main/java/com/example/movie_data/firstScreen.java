package com.example.movie_data;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class firstScreen extends Fragment implements View.OnClickListener {

    Button btlogin;


    public firstScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_screen, container, false);

        btlogin = view.findViewById(R.id.btlogin);
        btlogin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new loginScreen()).commit();
    }
}
