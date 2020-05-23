package com.example.demoretrofit2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoretrofit2.R;
import com.example.demoretrofit2.model.AudioBook;

import java.util.ArrayList;
import java.util.List;

public class AudioBookAdapter extends RecyclerView.Adapter<AudioBookAdapter.ViewHolder>{
    Context context;
    ArrayList<AudioBook> listAudioBook;

    public AudioBookAdapter(Context context, ArrayList<AudioBook> listAudioBook) {
        this.context = context;
        this.listAudioBook = listAudioBook;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowItem = layoutInflater.inflate(R.layout.item_audiobook, parent, false);
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.audiobookNameTextView.setText(listAudioBook.get(position).getName().toString());
        holder.authorTextView.setText(listAudioBook.get(position).getAuthor().toString());
    }

    @Override
    public int getItemCount() {
        return listAudioBook.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView audiobookNameTextView, authorTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            audiobookNameTextView = itemView.findViewById(R.id.audiobookNameTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
        }
    }
}
