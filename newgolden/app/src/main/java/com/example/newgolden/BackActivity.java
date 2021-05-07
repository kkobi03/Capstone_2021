package com.example.newgolden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BackActivity extends AppCompatActivity {

    private TextView timertv;
    private Button backbt;
    private CountDownTimer countdown ;
    private int remainingtime=30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        timertv = findViewById(R.id.timertv);
        backbt = findViewById(R.id.backbt);

        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BackActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        countdown=new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                remainingtime=(int)millisUntilFinished/1000;
                timertv.setText(String.valueOf(remainingtime));
            }

            @Override
            public void onFinish() {
                timertv.setText("Finished");//30초 타이머가 끝나면 자동으로 문자 전송되었습니다 페이지로 넘어가게
                Intent intent = new Intent(BackActivity.this, SmsActivity.class);
                startActivity(intent);


            }
        };
        countdown.start();
        backbt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}