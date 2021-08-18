package com.example.newkatyasnotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String noteName;
    private String noteText;

    public Note(String noteName, String noteText) {
        this.noteName = noteName;
        this.noteText = noteText;
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
