package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class WordActivity extends AppCompatActivity implements Drawable{
    ImageView voice_activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

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