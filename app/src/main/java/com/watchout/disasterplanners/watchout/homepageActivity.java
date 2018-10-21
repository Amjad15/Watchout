package com.watchout.disasterplanners.watchout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.watchout.disasterplanners.watchout.bag.CatalogActivity;

public class homepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ImageView location, disasters, bag;
        location = (ImageView) findViewById(R.id.imageView2);
        disasters = (ImageView) findViewById(R.id.imageView3);
        bag = (ImageView) findViewById(R.id.imageView4);

        disasters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageActivity.this,AlldisasterActivity.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepageActivity.this,CatalogActivity.class);
                startActivity(intent);
            }
        });


    }
}
