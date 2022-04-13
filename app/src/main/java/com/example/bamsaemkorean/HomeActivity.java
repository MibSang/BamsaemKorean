package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableRow;

public class HomeActivity extends AppCompatActivity {

    TableRow category_study_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        category_study_button = (TableRow) findViewById(R.id.category_study_button);

        category_study_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
            startActivity(intent);
        });

        /*
        drawerButton.setOnClickListener(view -> {
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerView = (View) findViewById(R.id.drawer_view);
            if (!drawerLayout.isDrawerOpen(Gravity.LEFT))
                drawerLayout.openDrawer(Gravity.LEFT);
        });
        */
    }
}