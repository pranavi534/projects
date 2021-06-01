package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class secondActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        String n = getIntent().getStringExtra("key");
        Toast.makeText(this, "Welcome "+n,
                Toast.LENGTH_SHORT).show();
    }
}