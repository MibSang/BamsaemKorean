package com.example.bamsaemkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText id_text;
    EditText pw_text;
    Button ok_button;
    Button cancel_button;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_text = (EditText) findViewById(R.id.id_text);
        pw_text = (EditText) findViewById(R.id.pw_text);
        ok_button = (Button) findViewById(R.id.ok_button);
        cancel_button = (Button) findViewById(R.id.cancel_button);
        spinner = (Spinner) findViewById(R.id.language_choice);

        ok_button.setOnClickListener(v -> {
            if (id_text.getText().toString().equals("test") && pw_text.getText().toString().equals("test")) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "잘못된 로그인 정보입니다.",Toast.LENGTH_SHORT).show();
            }
        });

        cancel_button.setOnClickListener(v -> {
            System.out.println("cancel clicked");
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if(pos == 0){
                    ok_button.setText("ko");
                }
                else if(pos == 1){
                    ok_button.setText("en");
                }
                else if(pos == 2){
                    ok_button.setText("ch");
                }
                else{
                    ok_button.setText("jp");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * 키보드 다른 영역 터치시 키보드 내리기
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null
                && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE)
                && view instanceof EditText
                && !view.getClass().getName().startsWith("android.webkit.")) {
            int[] scrcoords = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}