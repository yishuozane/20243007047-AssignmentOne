package com.example.assignmentone;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Receive category index from MainActivity.
        int categoryIndex = getIntent().getIntExtra("category_index", 0);

        String[] categories = {
                "Facilities",
                "Events",
                "Clubs",
                "Support"
        };

        TextView detailTitle = findViewById(R.id.detailTitle);

        // Show the selected category title.
        detailTitle.setText(categories[categoryIndex]);
    }
}