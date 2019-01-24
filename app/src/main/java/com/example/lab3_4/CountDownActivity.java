package com.example.lab3_4;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CountDownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        final TextView countDownTextView = (TextView) findViewById(R.id.countdown_text_id);

        String aika = getIntent().getStringExtra("aika");
        long kesto = Integer.parseInt(aika) * 1000;

        new CountDownTimer(kesto, 1000) {
            public void onTick(long millisUntilFinished) {
                countDownTextView.setText(String.valueOf(millisUntilFinished / 1000));
            }
            public void onFinish() {
                countDownTextView.setText("0");
                Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), alarm);
                mediaPlayer.start();
                new CountDownTimer(4000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    public void onFinish() {
                        mediaPlayer.stop();
                        finish();
                    }
                }.start();
            }
        }.start();
    }
}
