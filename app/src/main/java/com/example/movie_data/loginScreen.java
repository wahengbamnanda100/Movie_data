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
public class loginScreen extends Fragment implements View.OnClickListener {

    Button btsignup;


    public loginScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_screen, container, false);

        btsignup = view.findViewById(R.id.btsubmit);
        btsignup.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new movieInput()).commit();

    }
}
