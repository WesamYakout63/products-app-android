package com.example.myapplication.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private CardView cv;
    private TextView title;
    private TextView description;
    private TextView details;
    private ImageView imageView;
    private TextView price;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        cv =  itemView.findViewById(R.id.cardView);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        price = itemView.findViewById(R.id.price);
        imageView = itemView.findViewById(R.id.imageView);
        details = itemView.findViewById(R.id.details);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getPrice() {
        return price;
    }

    public TextView getDetails() {
        return details;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }

    public void setDetails(TextView details) { this.details = details; }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }



}
