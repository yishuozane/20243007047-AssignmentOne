package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Main screen of the CampusLife application.
 * Displays four campus service categories and handles navigation
 * to the corresponding detail screen.
 */

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
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom);
                    return insets;
                });

        ImageButton btnFacilities = findViewById(R.id.btnFacilities);
        ImageButton btnEvents = findViewById(R.id.btnEvents);
        ImageButton btnClubs = findViewById(R.id.btnClubs);
        ImageButton btnSupport = findViewById(R.id.btnSupport);

        btnFacilities.setOnClickListener(v -> openDetail(0));
        btnEvents.setOnClickListener(v -> openDetail(1));
        btnClubs.setOnClickListener(v -> openDetail(2));
        btnSupport.setOnClickListener(v -> openDetail(3));
    }

    // Open the detail screen with the selected category index.
    /**
     * Opens DetailActivity for the selected campus category.
     *
     * @param categoryIndex index of the selected category (0-3)
     */
    private void openDetail(int categoryIndex) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("category_index", categoryIndex);
        startActivity(intent);
    }
}