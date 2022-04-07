package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class WordActivity extends AppCompatActivity {

    ImageButton writing_activity_button;
    ImageButton voice_activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        writing_activity_button = (ImageButton) findViewById(R.id.writing_activity_button);
        voice_activity_button = (ImageButton) findViewById(R.id.voice_activity_button);

        writing_activity_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WritingActivity.class);
            startActivity(intent);
        });

        voice_activity_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), VoiceActivity.class);
            startActivity(intent);
        });
    }
}