package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recyclerview);

        int[] images = {R.drawable.beans,R.drawable.califlower,R.drawable.carrot,R.drawable.cucumber,R.drawable.drumstick,R.drawable.paneer,R.drawable.potato,R.drawable.radish,R.drawable.tomato,R.drawable.vegcurry};

        String[] itemNames = {"beans","califlower","carrot","cucumber","drumstick","paneer","potato","radish","tomato","vegcurry"};
        String[] itemPrices = {"100","150","100","120","350","200","180","250","150","140"};
        rv.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(this,images,itemNames,itemPrices);
    }
}