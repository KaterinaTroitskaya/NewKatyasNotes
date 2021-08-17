package com.example.newkatyasnotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String noteName;
    private int textIndex;

    public Note(int textIndex, String noteName) {
        this.noteName = noteName;
        this.textIndex = textIndex;
    }

    protected Note(Parcel in) {
       textIndex = in.readInt();
        noteName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(textIndex);
        dest.writeString(noteName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

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

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public void setTextIndex(int textIndex) {
        this.textIndex = textIndex;
    }


    public String getNoteName() {
        return noteName;
    }


    public int getTextIndex() {
        return textIndex;
    }
}
