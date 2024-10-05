package com.example.myapplication.ui.gallery;

import com.example.myapplication.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SensorDataFragment extends Fragment {

    private TextView textMQ2, textMQ4, textMQ7, textMQ135;
    private DatabaseReference databaseReference;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Find TextViews by their IDs
        textMQ2 = root.findViewById(R.id.text_mq2);
        textMQ4 = root.findViewById(R.id.text_mq4);
        textMQ7 = root.findViewById(R.id.text_mq7);
        textMQ135 = root.findViewById(R.id.text_mq135);

        // Find ImageButtons by their IDs
        imageButton1 = root.findViewById(R.id.imageButton1);
        imageButton2 = root.findViewById(R.id.imageButton2);
        imageButton3 = root.findViewById(R.id.imageButton3);
        imageButton4 = root.findViewById(R.id.imageButton4);

        // Set click listeners for the ImageButtons
        imageButton1.setOnClickListener(v -> {
            // Action for Button 1
        });

        imageButton2.setOnClickListener(v -> {
            // Action for Button 2
        });

        imageButton3.setOnClickListener(v -> {
            // Action for Button 3
        });

        imageButton4.setOnClickListener(v -> {
            // Action for Button 4
        });

        // Get a reference to the Firebase Realtime Database
        databaseReference = FirebaseDatabase.getInstance().getReference("sensorData");

        // Fetch sensor data from Firebase
        fetchSensorData();

        return root;
    }

    private void fetchSensorData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Fetch and display sensor data
                    String mq2 = snapshot.child("mq2").getValue(String.class);
                    String mq4 = snapshot.child("mq4").getValue(String.class);
                    String mq7 = snapshot.child("mq7").getValue(String.class);
                    String mq135 = snapshot.child("mq135").getValue(String.class);

                    textMQ2.setText("MQ2 Sensor: " + mq2);
                    textMQ4.setText("MQ4 Sensor: " + mq4);
                    textMQ7.setText("MQ7 Sensor: " + mq7);
                    textMQ135.setText("MQ135 Sensor: " + mq135);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error if data fetch fails
            }
        });
    }
}
