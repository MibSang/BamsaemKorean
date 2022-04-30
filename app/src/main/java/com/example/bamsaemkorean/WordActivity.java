package com.example.bamsaemkorean;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.lang.reflect.Field;

public class WordActivity extends AppCompatActivity implements Drawable {
    ImageButton writing_activity_button;
    ImageButton voice_activity_button;
    ImageButton before_button;
    ImageButton next_button;
    ImageView word_image_m;
    ImageView speak_button;
    TextToSpeech tts;
    TextView word_pos_text;
    TextView word_name_text;
    TextView word_name_sec;
    TextView word_exp;
    int index = 0;
    final int PERMISSION = 1;
    private static final int RECORD_AUDIO_PERMISSION_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        if ( Build.VERSION.SDK_INT >= 23 ){
            // 퍼미션 체크
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO},PERMISSION);
        }

        speak_button = (ImageView) findViewById(R.id.speak_button);
        writing_activity_button = (ImageButton) findViewById(R.id.writing_activity_button);
        voice_activity_button = (ImageButton) findViewById(R.id.voice_activity_button);
        before_button = (ImageButton) findViewById(R.id.imageButton3);
        next_button = (ImageButton) findViewById(R.id.imageButton4);
        word_name_text = (TextView) findViewById(R.id.word_name);
        word_name_sec = (TextView) findViewById(R.id.word_name_sec);
        word_pos_text = (TextView) findViewById(R.id.textView12);
        word_exp = (TextView) findViewById(R.id.textView);
        word_image_m = (ImageView) findViewById(R.id.word_image);

        Intent data = getIntent();

        final String category = data.getStringExtra("category");
        final String[] word_category = getResources().getStringArray(R.array.word_category);
        final String[] word_name = getResources().getStringArray(R.array.word_name);
        final String[] word_pos = getResources().getStringArray(R.array.word_pos);
        final String[] word_explanation = getResources().getStringArray(R.array.word_explanation);
        final String[] image_id = getResources().getStringArray(R.array.image_id);

        while (!word_category[index].equals(category)) {
            index++;
            if (index == word_category.length)
                index = 0;
        }
        word_name_text.setText(word_name[index]);
        word_name_sec.setText(word_name[index]);
        word_pos_text.setText(word_pos[index]);
        word_exp.setText(word_explanation[index]);
        word_image_m.setImageResource(getResId(image_id[index], R.drawable.class));

        writing_activity_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), WritingActivity.class);
            startActivity(intent);
        });

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
      
        before_button.setOnClickListener(v -> {
            do {
                index--;
                if (index == -1)
                    index = word_category.length-1;
            } while (!word_category[index].equals(category));

            word_name_text.setText(word_name[index]);
            word_name_sec.setText(word_name[index]);
            word_pos_text.setText(word_pos[index]);
            word_exp.setText(word_explanation[index]);
            word_image_m.setImageResource(getResId(image_id[index], R.drawable.class));
        });

        next_button.setOnClickListener(v -> {
            do {
                index++;
                if (index == word_category.length)
                    index = 0;
            } while (!word_category[index].equals(category));

            word_name_text.setText(word_name[index]);
            word_name_sec.setText(word_name[index]);
            word_pos_text.setText(word_pos[index]);
            word_exp.setText(word_explanation[index]);
            word_image_m.setImageResource(getResId(image_id[index], R.drawable.class));
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

    @Override
    public void openDrawer() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (!drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.openDrawer(GravityCompat.START);
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}