package com.example.studywilke;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView countdownValueTextView;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownValueTextView = findViewById(R.id.countdownValueTextView);


        long examDateMillis = getExamDateMillis();


        startCountdownTimer(examDateMillis);
    }

    private long getExamDateMillis() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date examDate;
        try {
            examDate = sdf.parse("09/06/2024");
            return examDate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void startCountdownTimer(long examDateMillis) {
        countDownTimer = new CountDownTimer(examDateMillis - System.currentTimeMillis(), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                updateCountdownText(millisUntilFinished);
            }

            @Override
            public void onFinish() {

            }
        };

        countDownTimer.start();
    }

    private void updateCountdownText(long millisUntilFinished) {

        long days = millisUntilFinished / (1000 * 60 * 60 * 24);
        long hours = (millisUntilFinished % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (millisUntilFinished % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (millisUntilFinished % (1000 * 60)) / 1000;

        String countdownText = String.format(Locale.getDefault(), "%d gün %d saat %d dakika %d saniye", days, hours, minutes, seconds);
        countdownValueTextView.setText(countdownText);
    }


    public void soruDagilimiClick(View view) {
        Intent intent = new Intent(this, SoruDagilimiActivity.class);
        startActivity(intent);
    }

    public void grammerCozumuClick(View view) {
        Intent intent = new Intent(this, GrammerCozumuActivity.class);
        startActivity(intent);
    }

    public void kelimeDefteriClick(View view) {
        Intent intent = new Intent(this, KelimeDefteriActivity.class);
        startActivity(intent);
    }
}
