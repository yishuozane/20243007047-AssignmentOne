package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                });

        ImageButton btnFacilities = findViewById(R.id.btnFacilities);
        ImageButton btnEvents = findViewById(R.id.btnEvents);
        ImageButton btnClubs = findViewById(R.id.btnClubs);
        ImageButton btnSupport = findViewById(R.id.btnSupport);

        btnFacilities.setOnClickListener(v ->
                Toast.makeText(this, "Facilities clicked",
                        Toast.LENGTH_SHORT).show());

        btnEvents.setOnClickListener(v ->
                Toast.makeText(this, "Events clicked",
                        Toast.LENGTH_SHORT).show());

        btnClubs.setOnClickListener(v ->
                Toast.makeText(this, "Clubs clicked",
                        Toast.LENGTH_SHORT).show());

        btnSupport.setOnClickListener(v ->
                Toast.makeText(this, "Support clicked",
                        Toast.LENGTH_SHORT).show());
    }
}