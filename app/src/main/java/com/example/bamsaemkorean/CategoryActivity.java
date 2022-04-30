package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity implements Drawable{
    ImageView world_category_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        world_category_button = (ImageView) findViewById(R.id.world_category_button);

        world_category_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
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