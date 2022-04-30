package com.example.bamsaemkorean;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WritingActivity extends AppCompatActivity {
    ImageView writing_back_button;
    ImageView word_erase_button;
    ImageView pencil_image;
    TextView word_canvas;
    TextView word_name_text;
    TextView word_pos_text;
    LinearLayout letter_layout;
    TextView[] letter_text;
    int cur_letter = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        writing_back_button = (ImageView) findViewById(R.id.writing_back_button);
        word_erase_button = (ImageView) findViewById(R.id.word_erase_button); // 지우개
        word_canvas = (TextView) findViewById(R.id.word_canvas);
        word_name_text = (TextView) findViewById(R.id.word_name_text1);
        word_pos_text = (TextView) findViewById(R.id.word_pos_text);
        pencil_image = (ImageView) findViewById(R.id.imageView3);
        letter_layout = (LinearLayout) findViewById(R.id.letter_layout);
        MyView myView = (MyView) findViewById(R.id.draw);

        Intent data = getIntent();
        String word = data.getStringExtra("word");
        String[] letter = word.split("");

        word_name_text.setText(word);
        word_pos_text.setText(data.getStringExtra("pos"));
        word_canvas.setText(letter[0]);

        letter_text = new TextView[letter.length];
        for (int i = 0; i < letter.length; i++) {
            letter_text[i] = new TextView(this);
            letter_layout.addView(letter_text[i]);
            letter_text[i].setText(letter[i]);
            letter_text[i].setWidth(ConvertDPtoPX(this, 42));
            letter_text[i].setHeight(ConvertDPtoPX(this, 42));
            letter_text[i].setBackgroundColor(Color.parseColor("#C1B388"));
            letter_text[i].setTextSize(24);
            letter_text[i].setTextColor(getColor(R.color.white));
            letter_text[i].setGravity(0x10 | 0x01);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 4, 4, 4);
            letter_text[i].setLayoutParams(params);
            if (i == 0) {
                letter_text[i].setBackgroundColor(Color.parseColor("#937F40"));
            }

            letter_text[i].setOnClickListener(v -> {
                int cur = -1;
                for (int j = 0; j < letter.length; j++) {
                    if (letter_text[j].equals(v)) {
                        cur = j;
                    }
                    letter_text[j].setBackgroundColor(Color.parseColor("#C1B388"));
                }
                if (cur == -1)
                    cur = cur_letter;
                cur_letter = cur;
                int[] loc = new int[2];
                letter_text[cur].getLocationInWindow(loc);
                pencil_image.setX(loc[0]+10);
                pencil_image.setY(loc[1]-110);
                letter_text[cur].setBackgroundColor(Color.parseColor("#937F40"));
                word_canvas.setText(letter[cur]);
                myView.reset();
            });
        }

        Handler delayHandler = new Handler();
        delayHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] loc = new int[2];
                letter_text[0].getLocationInWindow(loc);
                pencil_image.setX(loc[0]+10);
                pencil_image.setY(loc[1]-110);
            }
        }, 100);

        writing_back_button.setOnClickListener(view->{
            finish();
        });

        word_erase_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.reset();
            }
        });
    }

    public static int ConvertDPtoPX(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static class MyView extends AppCompatTextView {
        private float x, y;
        private final Paint paint = new Paint();
        private final Path path = new Path();

        public MyView(Context context){
            super(context);

            paint.setAntiAlias(true);
            paint.setStrokeWidth(50f);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
        }

        public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);

            paint.setAntiAlias(true);
            paint.setStrokeWidth(50f);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();

            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(x,y);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x,y);
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                default:
                    return false;
            }
            invalidate();
            return true;
        }

        public void reset(){ // Canvas에서 그린 것들 지우기
            path.reset();
            invalidate();
        }
    }
}