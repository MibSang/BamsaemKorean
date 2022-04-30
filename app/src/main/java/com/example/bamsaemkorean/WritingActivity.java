package com.example.bamsaemkorean;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WritingActivity extends AppCompatActivity {
    ImageView writing_back_button;
    ImageView word_erase_button;
    TextView word_canvas;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        writing_back_button = (ImageView) findViewById(R.id.writing_back_button);
        word_erase_button = (ImageView) findViewById(R.id.word_erase_button); // 지우개
        word_canvas = (TextView) findViewById(R.id.word_canvas);
        MyView myView = (MyView) findViewById(R.id.draw);

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