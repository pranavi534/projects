package com.example.graphsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity {
    BarChart bc;
    ArrayList<BarEntry>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        bc = findViewById(R.id.bc);
        entries = new ArrayList();
        entries.add(new BarEntry(2000,1));
        entries.add(new BarEntry(2001,1));
        entries.add(new BarEntry(2000,1));
        entries.add(new BarEntry(2000,1));
        entries.add(new BarEntry(2000,1));


    }
}