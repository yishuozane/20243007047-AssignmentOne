package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Displays detailed CampusLife information for a selected category.
 * Uses a category index and Android resource arrays to update
 * the icon, title and description without category-specific branching.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Receive the category selected on the main screen.
        int categoryIndex = getIntent().getIntExtra(
                "category_index", -1);

        // Load the three arrays from Android resources.
        String[] images = getResources().getStringArray(
                R.array.string_array_images);

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles);

        String[] contents = getResources().getStringArray(
                R.array.string_array_content);

        // Validate the index before accessing the arrays.
        if (categoryIndex < 0 ||
                categoryIndex >= images.length ||
                categoryIndex >= titles.length ||
                categoryIndex >= contents.length) {
            finish();
            return;
        }

        // Connect Java variables to the XML views.
        ImageView detailIcon = findViewById(R.id.detailIcon);
        TextView detailTitle = findViewById(R.id.detailTitle);
        TextView detailContent = findViewById(R.id.detailContent);

        // Display the selected title and description.
        detailTitle.setText(titles[categoryIndex].trim());
        detailContent.setText(contents[categoryIndex].trim());

        // Convert the image name into a drawable resource ID.
        String imageName = images[categoryIndex].trim();

        int imageId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName()
        );

        // Display the selected category icon.
        detailIcon.setImageResource(imageId);
    }
}