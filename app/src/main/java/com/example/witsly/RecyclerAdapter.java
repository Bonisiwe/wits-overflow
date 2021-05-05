package com.example.witsly;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private final ArrayList<CardItem> mPostList;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView mPosterDetails;
        public TextView mPostTitle;
        public TextView mPostBody;
        public TextView mVoteCount;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mPosterDetails = itemView.findViewById(R.id.tv_poster2);
            mPostTitle = itemView.findViewById(R.id.tv_card_title2);
            mPostBody = itemView.findViewById(R.id.tv_card_body2);
            mVoteCount = itemView.findViewById(R.id.tv_vote_count2);
        }
    }

    public RecyclerAdapter(ArrayList<CardItem> postList) {
        mPostList = postList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item2, parent, false);
        RecyclerViewHolder RVH = new RecyclerViewHolder(v);
        return RVH;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        CardItem cItem = mPostList.get(position);


        holder.mPostTitle.setText(cItem.getPostTitle());

        if (cItem.getPostBody().length() > 10) {
            holder.mPostBody.setText((cItem.getPostTitle()).substring(0, 10));
        } else {
            holder.mPostBody.setText(cItem.getPostTitle());
        }
        holder.mPosterDetails.setText(cItem.getPosterDetails());
        holder.mPostBody.setText(cItem.getPostBody());
        holder.mVoteCount.setText(cItem.getVoteCount() + "");
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }
}