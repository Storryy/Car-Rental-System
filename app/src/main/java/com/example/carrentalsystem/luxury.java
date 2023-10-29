package com.example.carrentalsystem;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class luxury extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_luxury, container, false);
        ImageButton m2ImageButton;
        ImageButton q3ImageButton;
        ImageButton ftypeImageButton;
        m2ImageButton = (ImageButton) view.findViewById(R.id.m2ImageButton);
        q3ImageButton = (ImageButton) view.findViewById(R.id.q3ImageButton);
        ftypeImageButton = (ImageButton) view.findViewById(R.id.ftypeImageButton);

        m2ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "BMW M2";
                String strName = getActivity().getIntent().getStringExtra("name");
                String emailToText = getActivity().getIntent().getStringExtra("email");
                String strDate = getActivity().getIntent().getStringExtra("date");
                String strAddress = getActivity().getIntent().getStringExtra("address");
                Intent intent = new Intent(getActivity(), DriverSelectActivity.class);
                intent.putExtra("name", strName);
                intent.putExtra("email", emailToText);
                intent.putExtra("date", strDate);
                intent.putExtra("address", strAddress);
                intent.putExtra("car", Car);
                startActivity(intent);

            }
        });

        q3ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Audi Q3";
                String strName = getActivity().getIntent().getStringExtra("name");
                String emailToText = getActivity().getIntent().getStringExtra("email");
                String strDate = getActivity().getIntent().getStringExtra("date");
                String strAddress = getActivity().getIntent().getStringExtra("address");
                Intent intent = new Intent(getActivity(), DriverSelectActivity.class);
                intent.putExtra("name", strName);
                intent.putExtra("email", emailToText);
                intent.putExtra("date", strDate);
                intent.putExtra("address", strAddress);
                intent.putExtra("car", Car);
                startActivity(intent);
            }
        });

        ftypeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Jaguar F Type";
                String strName = getActivity().getIntent().getStringExtra("name");
                String emailToText = getActivity().getIntent().getStringExtra("email");
                String strDate = getActivity().getIntent().getStringExtra("date");
                String strAddress = getActivity().getIntent().getStringExtra("address");
                Intent intent = new Intent(getActivity(), DriverSelectActivity.class);
                intent.putExtra("name", strName);
                intent.putExtra("email", emailToText);
                intent.putExtra("date", strDate);
                intent.putExtra("address", strAddress);
                intent.putExtra("car", Car);
                startActivity(intent);
            }
        });

        return view;

    }
}