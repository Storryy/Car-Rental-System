package com.example.carrentalsystem;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class hatchback extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hatchback, container, false);
        ImageButton swiftImageButton;
        ImageButton wagonrImageButton;
        ImageButton i20ImageButton;
        swiftImageButton = (ImageButton) view.findViewById(R.id.swiftImageButton);
        wagonrImageButton = (ImageButton) view.findViewById(R.id.wagonrImageButton);
        i20ImageButton = (ImageButton) view.findViewById(R.id.i20ImageButton);

        swiftImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Maruti Suzuki Swift";
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

        wagonrImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Maruti Suzuki Wagonr";
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

        i20ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Hyundai i20";
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