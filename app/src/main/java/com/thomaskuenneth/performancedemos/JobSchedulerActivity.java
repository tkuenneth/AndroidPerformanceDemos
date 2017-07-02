package com.thomaskuenneth.performancedemos;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;

public class JobSchedulerActivity extends Activity {

    private static final int JOB_ID = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentName cn = new ComponentName(this, DemoJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, cn);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPeriodic(JobInfo.getMinPeriodMillis());

        JobScheduler js = getSystemService(JobScheduler.class);
        js.schedule(builder.build());

        finish();
    }
}
