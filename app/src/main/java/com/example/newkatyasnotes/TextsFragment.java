package com.example.newkatyasnotes;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        TextView textView = view.findViewById(R.id.notesTextView);
        TextView nameView = view.findViewById(R.id.notesNameView);
        nameView.setText(this.note.getNoteName());

        TypedArray typedArray = getResources().obtainTypedArray(R.array.notes_texts);
        textView.setText(typedArray.getResourceId(this.note.getTextIndex(),-1));

       return view;

    }
}
