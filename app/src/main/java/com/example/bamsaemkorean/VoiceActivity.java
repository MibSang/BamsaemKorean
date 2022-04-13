package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;

public class VoiceActivity extends AppCompatActivity {
    private static final int RECORD_AUDIO_PERMISSION_CODE = 0;

    TextView land_name;
    TextView stt_result;
    ImageButton read_land_name_button;
    ImageButton record_button;
    Button compare_voice;
    Intent intent;
    SpeechRecognizer stt;
    RecognitionListener listener;
    final int PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        stt_result = (TextView)findViewById(R.id.stt_result); // stt결과 표시
        land_name = (TextView)findViewById(R.id.textView); // 최상단의 나라이름 (나라가 뭔지에 따라 값이 바뀜)
        read_land_name_button = (ImageButton)findViewById((R.id.read_land_name_button)); // 버튼 누를 시 Land_name(나라이름) 텍스트를 읽어줌
        compare_voice = (Button)findViewById(R.id.compare_voice); // 기준 발음과 비슷한지 비교해주는 버튼
        record_button = (ImageButton)findViewById(R.id.record_button); // 녹음 버튼

        listener = new STTListener(getContext(), stt_result);
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
        stt = SpeechRecognizer.createSpeechRecognizer(this);
        stt.setRecognitionListener(listener);

        // Google STT 작동 가능한지 확인
        if ( Build.VERSION.SDK_INT >= 23 ){
            // 퍼미션 체크
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO},PERMISSION);
        }

        //버튼 onClick
        record_button.setOnClickListener(v ->{
            stt=SpeechRecognizer.createSpeechRecognizer(this);
            stt.setRecognitionListener(listener);
            stt.startListening(intent);
        });

    }
    private Activity getActivity() { return this; }
    private Context getContext() { return this; }
}