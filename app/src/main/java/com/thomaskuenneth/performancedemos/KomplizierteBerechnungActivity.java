package com.thomaskuenneth.performancedemos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class KomplizierteBerechnungActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.komplizierte_berechnung);
        TextView output = (TextView) findViewById(R.id.output);
        Button calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener((c) -> {
            output.setText(R.string.blocked);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                output.setText(R.string.app_name);
            }
            output.setText(R.string.not_blocked);
        });
    }
}
