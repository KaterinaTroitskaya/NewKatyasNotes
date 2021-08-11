package com.example.newkatyasnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.notes, NotesFragment.newInstance()).commit();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager().beginTransaction().replace(R.id.texts, TextsFragment.newInstance()).commit();
        }

    }
}