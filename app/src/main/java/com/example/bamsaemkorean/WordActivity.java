package com.example.bamsaemkorean;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class WordActivity extends AppCompatActivity {
    private static final int RECORD_AUDIO_PERMISSION_CODE = 0;
    ImageView voice_activity_button;
    ImageView speak_button;
    TextToSpeech tts;
    TextView country_name;
    final int PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        if ( Build.VERSION.SDK_INT >= 23 ){
            // 퍼미션 체크
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO},PERMISSION);
        }

        voice_activity_button = (ImageView) findViewById(R.id.voice_activity_button);
        speak_button = (ImageView) findViewById(R.id.speak_button);
        country_name = (TextView) findViewById(R.id.country_name);


        voice_activity_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), VoiceActivity.class);
            startActivity(intent);
        });

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        speak_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override public void onClick(View v) {
                CharSequence text = country_name.getText();
                tts.setPitch(1.0f);
                tts.setSpeechRate(1.0f);
                tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"id1");
            }
        });

    }
    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
        super.onDestroy();
    }
}