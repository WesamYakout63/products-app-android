package com.example.myapplication.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;
import com.example.myapplication.view.ViewHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<ViewHolder> {


    private List<Product> list;
    private Context context;

    public Adapter(List<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        TextView details = holder.getDetails();
        details.setText(list.get(position).get_Prouduct());
        holder.setDetails(details);
        TextView title = holder.getTitle();
        title.setText(list.get(position).getName());
        holder.setTitle(title);
        TextView description = holder.getDescription();
        description.setText(list.get(position).getDescription());
        holder.setDescription(description);
        TextView price = holder.getPrice();
        price.setText(list.get(position).getPrice());
        holder.setPrice(price);
        String url = list.get(position).getImage_url();
        ImageView v = holder.getImageView();
        picasso_viewer(url , v);
//        Universal_Image_Loader(url , v);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Product data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Product data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    private ImageView picasso_viewer(String url , ImageView v) {
        Picasso.with(context).load(url).placeholder(R.drawable.loading)
                .error(R.drawable.error).into(v);
        return v;
    }

    private void Universal_Image_Loader(String url , ImageView v) {

        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true).build();
        imageLoader.displayImage(url, v , options , new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
//                imageLoader.displayImage("drawable://" + R.drawable.loading , (ImageView) view);
                Log.i("Loading" , "Placeholder" + imageUri);
                v.setImageResource(R.drawable.loading );
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                imageLoader.displayImage("drawable://" + R.drawable.error , (ImageView) view);
                Log.i("Error" , "display error view" + imageUri);
                v.setImageResource(R.drawable.error);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                imageLoader.displayImage(imageUri , (ImageView) view);
                Log.i("success" , "image loaded successfully" + imageUri);
                v.setImageBitmap(loadedImage);

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
//                imageLoader.displayImage("drawable://" + R.drawable.error , (ImageView) view);
                Log.i("Cancelled" , "display error view" + imageUri);
                v.setImageResource(R.drawable.error);
            }
        });
    }

}
