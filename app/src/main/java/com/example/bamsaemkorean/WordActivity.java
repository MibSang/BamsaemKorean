package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

public class WordActivity extends AppCompatActivity implements Drawable{
    ImageButton writing_activity_button;
    ImageButton voice_activity_button;
    ImageButton before_button;
    ImageButton next_button;
    TextView word_name;
    TextView word_name_sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        writing_activity_button = (ImageButton) findViewById(R.id.writing_activity_button);
        voice_activity_button = (ImageButton) findViewById(R.id.voice_activity_button);
        word_name = (TextView) findViewById(R.id.word_name);
        word_name_sec = (TextView) findViewById(R.id.word_name_sec);

        Intent data = getIntent();

        // 자연환경
        String nature[] = data.getStringArrayExtra("natural_environment_data");
        word_name.setText(nature[0]);
        word_name_sec.setText(nature[0]);

        // 대중문화
        //String culture[] = data.getStringArrayExtra("popular_culture_data");
        //word_name.setText(culture[0]);
        //word_name_sec.setText(culture[0]);

        writing_activity_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WritingActivity.class);
            startActivity(intent);
        });

        voice_activity_button = (ImageView) findViewById(R.id.voice_activity_button);

        voice_activity_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), VoiceActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void openDrawer() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (!drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.openDrawer(GravityCompat.START);
    }
}