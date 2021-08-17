package com.example.newkatyasnotes;

import android.content.res.Configuration;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NotesFragment extends Fragment {
    public static String KEY_NOTE = "note";
    boolean isLandScape;
    Note currentNote;

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        Log.d("mylogs", "savedInstanceState!=null " + (savedInstanceState != null));
        if (savedInstanceState != null) {
            currentNote = savedInstanceState.getParcelable(KEY_NOTE);
        }
        Log.d("mylogs", "currentNote!=null " + (currentNote != null));
        if(isLandScape)
            if(currentNote!=null){
                showNotesTexts(currentNote.getTextIndex());
            } else {
                showNotesTexts(0);
            }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(KEY_NOTE, currentNote);
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        LinearLayout linearLayout = (LinearLayout) view;

        String[] notes = getResources().getStringArray(R.array.notes_names);

        for (int i = 0; i < notes.length; i++) {
            String name = notes[i];
            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setTextSize(30);
            linearLayout.addView(textView);
            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showNotesTexts(finalI);
                }
            });
        }
        return view;
    }

    private void showNotesTexts(int index) {
        currentNote = new Note(index,
                (getResources().getStringArray(R.array.notes_names)[index]));
        if (isLandScape) {
            showNotesTextsLand();
        } else { // port
            showNotesTextsPort();
        }
    }

    private void showNotesTextsPort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes_container, TextsFragment.newInstance(currentNote))
                .addToBackStack("")
                .commit();
    }

    private void showNotesTextsLand() {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notes_container, TextsFragment.newInstance(currentNote))
                    .commit();
    }
}
