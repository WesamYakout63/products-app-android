package com.example.myapplication.controllers;

import android.view.View;

public interface Listener {
    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}

