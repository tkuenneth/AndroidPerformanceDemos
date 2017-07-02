package com.thomaskuenneth.performancedemos;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskActivity extends Activity {

    View view;

    Timer timer;
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timertask);
        view = findViewById(R.id.timertask);
    }

    @Override
    protected void onStart() {
        super.onStart();
        timer = new Timer();
        timerTask = new TimerTask() {

            volatile boolean b = false;

            @Override
            public void run() {
                runOnUiThread(() -> {
                    view.setBackgroundColor(b ? Color.RED : Color.WHITE);
                    b = !b;
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 2000, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }
}
