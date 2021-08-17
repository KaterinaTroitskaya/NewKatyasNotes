package com.example.newkatyasnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TextsFragment extends Fragment {
    private Note note;
    public static String ARG_NOTE = "note";


    public static TextsFragment newInstance(Note note){
        TextsFragment fragment = new TextsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            this.note = getArguments().getParcelable(ARG_NOTE);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_texts, container, false);
        TextView namestextView = view.findViewById(R.id.namesTextView);
        TextView textstextView = view.findViewById(R.id.textsTextView);
        namestextView.setText(this.note.getNoteName());

        String[] resArray = getResources().getStringArray(R.array.notes_texts);
        textstextView.setText(resArray[this.note.getTextIndex()]);

        return view;

    }
}
