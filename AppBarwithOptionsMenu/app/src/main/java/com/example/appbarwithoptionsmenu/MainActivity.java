package com.example.appbarwithoptionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Res >>to access into java file(R.java is used)
        //Res >>to access into xml file
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Profile:
                Toast.makeText(this,"Profile", Toast.LENGTH_SHORT).show();
            case R.id.Name:
                Toast.makeText(this, "Name", Toast.LENGTH_SHORT).show();
                case R.id.Contact:
                    Toast.makeText(this,"Contact", Toast.LENGTH_SHORT).show();
            case R.id.Settings:
                Toast.makeText(this,"Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}