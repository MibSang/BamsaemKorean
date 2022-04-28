package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class WordActivity extends AppCompatActivity {
    ImageView voice_activity_button;
    ImageView speak_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        voice_activity_button = (ImageView) findViewById(R.id.voice_activity_button);
        speak_button = (ImageView) findViewById(R.id.speak_button);

        voice_activity_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), VoiceActivity.class);
            startActivity(intent);
        });
    }
}