package com.thomaskuenneth.performancedemos;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class DemoJobService extends JobService {

    private static final String TAG = DemoJobService.class.getSimpleName();

    private volatile boolean done;

    private Thread t;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "onStartJob()");
        t = new Thread(() -> {
            done = false;
            try {
                Thread.sleep(60000);
                done = true;
                jobFinished(params, false);
                Log.i(TAG, "Fertig!");
            } catch (InterruptedException e) {
                Log.e(TAG, "wurde unterbrochen", e);
            }
        });
        t.start();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "onStopJob()");
        t.interrupt();
        t = null;
        Log.i(TAG, "done=" + done);
        return !done;
    }
}
