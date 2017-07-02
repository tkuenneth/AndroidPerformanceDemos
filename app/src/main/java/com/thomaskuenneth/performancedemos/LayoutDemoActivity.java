package com.thomaskuenneth.performancedemos;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;

public class LayoutDemoActivity extends Activity {

    private FrameLayout f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdemo);

        f = (FrameLayout) findViewById(R.id.frame);
        Button linear = (Button) findViewById(R.id.linear);
        linear.setOnClickListener((v) -> updateFrameLayout(R.layout.linear));
        Button relative = (Button) findViewById(R.id.relative);
        relative.setOnClickListener((v) -> updateFrameLayout(R.layout.relative));
    }

    private void updateFrameLayout(int resId) {
        f.removeAllViews();
        LayoutInflater.from(this).inflate(resId, f);
    }
}
