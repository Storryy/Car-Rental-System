package com.example.carrentalsystem;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class suv extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_suv, container, false);
        ImageButton xuvImageButton;
        ImageButton cretaImageButton;
        ImageButton fortunerImageButton;
        xuvImageButton = (ImageButton) view.findViewById(R.id.xuvImageButton);
        cretaImageButton = (ImageButton) view.findViewById(R.id.cretaImageButton);
        fortunerImageButton = (ImageButton) view.findViewById(R.id.fortunerImageButton);

        xuvImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Mahindra XUV 700";
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

        cretaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Hyundai Creta";
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

        fortunerImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Toyota Fortuner";
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