package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;

public class VoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView land_name;
        ImageButton read_land_name_button;
        ImageButton record_button;
        Button compare_voice;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        land_name = findViewById(R.id.textView); // 최상단의 나라이름 (나라가 뭔지에 따라 값이 바뀜)
        read_land_name_button = findViewById((R.id.read_land_name_button)); // 버튼 누를 시 Land_name(나라이름) 텍스트를 읽어줌
        compare_voice = findViewById(R.id.compare_voice); // 기준 발음과 비슷한지 비교해주는 버튼
        record_button = findViewById(R.id.record_button); // 녹음 버튼

    }
}