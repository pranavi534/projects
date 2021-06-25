package com.example.examplework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    OneTimeWorkRequest firstrequest,thirdrequest;
    PeriodicWorkRequest secondrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constraints constraints = new Constraints
                .Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true).build();
        firstrequest = new OneTimeWorkRequest
                .Builder(FirstWork.class)
                .setInitialDelay(5,TimeUnit.SECONDS)
                .setConstraints(constraints)
                .build();


        secondrequest = new PeriodicWorkRequest.Builder(SecondWork.class,
                15, TimeUnit.MINUTES).build();
        thirdrequest = new OneTimeWorkRequest.Builder(ThirdWork.class).build();

    }

    public void start(View view) {
        WorkManager.getInstance(this).enqueue(firstrequest);
        WorkManager.getInstance(this).enqueue(secondrequest);

    }
    public void next(View view) {
        WorkManager.getInstance(this).beginWith(firstrequest).then(thirdrequest).enqueue();
    }
}