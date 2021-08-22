package com.example.newkatyasnotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String noteName;
    private String noteText;
    private int index;

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getIndex() {
        return index;
    }

    public Note(String noteName, String noteText, int index) {
        this.noteName = noteName;
        this.noteText = noteText;
        this.index = index;
    }

    protected Note(Parcel in) {
       noteText = in.readString();
        noteName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteText);
        dest.writeString(noteName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getNoteName() {
        return noteName;
    }

    public String getNoteText() {
        return noteText;
    }

}
