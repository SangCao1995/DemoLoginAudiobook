package com.example.demoretrofit2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListAudioBook {
    @SerializedName("data")
    private ArrayList<AudioBook> audioBooks;

    public ListAudioBook() {
    }

    public ListAudioBook(ArrayList<AudioBook> audioBooks) {
        this.audioBooks = audioBooks;
    }

    public ArrayList<AudioBook> getAudioBooks() {
        return audioBooks;
    }

    public void setAudioBooks(ArrayList<AudioBook> audioBooks) {
        this.audioBooks = audioBooks;
    }
}
