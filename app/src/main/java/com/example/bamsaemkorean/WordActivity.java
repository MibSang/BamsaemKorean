package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {
    ImageView world_category_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        world_category_button = (ImageView) findViewById(R.id.world_category_button);

        world_category_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), VoiceActivity.class);
            startActivity(intent);
        });
    }
}