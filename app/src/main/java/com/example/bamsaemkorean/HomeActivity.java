package com.example.bamsaemkorean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableRow;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements Drawable{

    TableRow category_study_button;
    TableRow team_introduce_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        category_study_button = (TableRow) findViewById(R.id.category_study_button);
        team_introduce_button = (TableRow) findViewById(R.id.team_introduce_button);

        category_study_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
            startActivity(intent);
        });

        team_introduce_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "team_data");
            startActivity(intent);
        });

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_logout) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_exit) {
                    finishAffinity();
                    System.runFinalization();
                    System.exit(0);
                }
                return true;
            }
        });*/

        /*
        drawerButton.setOnClickListener(view -> {
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerView = (View) findViewById(R.id.drawer_view);
            if (!drawerLayout.isDrawerOpen(Gravity.LEFT))
                drawerLayout.openDrawer(Gravity.LEFT);
        });
        */
    }

    @Override
    public void openDrawer() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (!drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.openDrawer(GravityCompat.START);
    }
}