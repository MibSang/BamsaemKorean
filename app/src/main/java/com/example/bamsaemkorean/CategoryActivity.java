package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity implements Drawable {
    ImageView category_back_button;
    ImageView category_country;
    ImageView category_natural_environment;
    ImageView category_popular_culture;
    ImageView category_special_day;
    ImageView category_life_plan;
    ImageView category_daily_life;
    ImageView category_daily_conversation;
    ImageView category_environmental_protection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category_back_button = (ImageView) findViewById(R.id.word_image);
        category_country = (ImageView) findViewById(R.id.category_country);
        category_natural_environment = (ImageView) findViewById(R.id.category_natural_environment);
        category_popular_culture = (ImageView) findViewById(R.id.category_popular_culture);
        category_special_day = (ImageView) findViewById(R.id.category_special_day);
        category_life_plan = (ImageView) findViewById(R.id.category_life_plan);
        category_daily_life = (ImageView) findViewById(R.id.category_daily_life);
        category_daily_conversation = (ImageView) findViewById(R.id.category_daily_conversation);
        category_environmental_protection = (ImageView) findViewById(R.id.category_environmental_protection);

        category_back_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        });

        category_country.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "country_data");

            startActivity(intent);
        });

        category_natural_environment.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "natural_environment_data");

            startActivity(intent);
        });

        category_popular_culture.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "popular_culture_data");

            startActivity(intent);
        });

        category_special_day.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "special_day_data");

            startActivity(intent);
        });

        category_life_plan.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "life_plan_data");

            startActivity(intent);
        });

        category_daily_life.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "daily_life_data");

            startActivity(intent);
        });

        category_daily_conversation.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "daily_conversation_data");

            startActivity(intent);
        });

        category_environmental_protection.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);
            intent.putExtra("category", "environmental_protection_data");

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