package com.example.carrentalsystem;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class sedan extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sedan, container, false);
        ImageButton ciazImageButton;
        ImageButton cityImageButton;
        ImageButton vernaImageButton;
        ciazImageButton = (ImageButton) view.findViewById(R.id.ciazImageButton);
        cityImageButton = (ImageButton) view.findViewById(R.id.cityImageButton);
        vernaImageButton = (ImageButton) view.findViewById(R.id.vernaImageButton);

        ciazImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Maruti Suzuki Ciaz";
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

        cityImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Honda City";
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

        vernaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car = "Hyundai Verna";
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