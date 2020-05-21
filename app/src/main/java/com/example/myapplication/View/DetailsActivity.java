package com.example.myapplication.view;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView textView = findViewById(R.id.text2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        if(getIntent().hasExtra("Details")) {
            textView.setText(getIntent().getStringExtra("Details"));
        }
        ImageView image = findViewById(R.id.imageView2);
        if(getIntent().hasExtra("Image")) {
            image.setImageBitmap(getIntent().getParcelableExtra("Image"));
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
