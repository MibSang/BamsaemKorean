package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {
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

        category_back_button = (ImageView) findViewById(R.id.category_back_button);
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
            startActivity(intent);
        });

        category_natural_environment.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);

            String[] natural_environment_data = {"산", "바다", "바람"};
            intent.putExtra("natural_environment_data", natural_environment_data);

            startActivity(intent);
        });

        category_popular_culture.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);

            String[] popular_culture_data = {"음악", "영화", "스포츠"};
            intent.putExtra("popular_culture_data", popular_culture_data);

            startActivity(intent);
        });

        category_special_day.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);

            String[] special_day_data = {"어린이날", "어버이날", "현충일"};
            intent.putExtra("special_day_data", special_day_data);

            startActivity(intent);
        });

        category_life_plan.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);

            String[] life_plan_data = {"여행", "취업", "노후"};
            intent.putExtra("life_plan_data", life_plan_data);

            startActivity(intent);
        });

        category_daily_life.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);

            String[] daily_life_data = {"운동", "축제", "학교"};
            intent.putExtra("daily_life_data", daily_life_data);

            startActivity(intent);
        });

        category_daily_conversation.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);

            String[] daily_conversation_data = {"밥 먹었어?", "잘 자", "잘 할거야"};
            intent.putExtra("daily_conversation_data", daily_conversation_data);

            startActivity(intent);
        });

        category_environmental_protection.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WordActivity.class);

            String[] environmental_protection_data = {"재활용", "분리수거", "친환경 소재"};
            intent.putExtra("environmental_protection_data", environmental_protection_data);

            startActivity(intent);
        });
    }
}