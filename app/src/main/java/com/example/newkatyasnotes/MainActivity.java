package com.example.newkatyasnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notes_container, NotesFragment.newInstance())
                    .commit();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.notes_container);
        if (backStackFragment!= null&&backStackFragment instanceof TextsFragment) {
            onBackPressed();
        }
    }
}