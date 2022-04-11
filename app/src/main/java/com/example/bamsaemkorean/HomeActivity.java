package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableRow;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    View drawerView;
    TableRow category_study_button;
    ImageButton drawerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        category_study_button = (TableRow) findViewById(R.id.category_study_button);
        drawerButton = (ImageButton) findViewById(R.id.imageButton2);

        category_study_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
            startActivity(intent);
        });

        drawerButton.setOnClickListener(view -> {
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerView = (View) findViewById(R.id.drawer_view);
            if (!drawerLayout.isDrawerOpen(Gravity.LEFT))
                drawerLayout.openDrawer(Gravity.LEFT);
        });
    }
}