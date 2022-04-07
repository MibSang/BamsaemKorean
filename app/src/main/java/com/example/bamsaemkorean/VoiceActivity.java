package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;

public class VoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView Land_name;
        ImageButton Land_name_to_speech;
        Button Compare_voice;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        Land_name = findViewById(R.id.Land_name); // 최상단의 나라이름 (나라가 뭔지에 따라 값이 바뀜)
        Land_name_to_speech = findViewById((R.id.Land_name_to_speech)); // 버튼 누를 시 Land_name(나라이름) 텍스트를 읽어줌
        Compare_voice = findViewById(R.id.Compare_voice); // 기준 발음과 비슷한지 비교해주는 버튼

        //Land_name = 새로운 나라이름 받기;

    }
}