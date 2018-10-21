package com.watchout.disasterplanners.watchout.disasters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.watchout.disasterplanners.watchout.R;


public class earthquakeActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster);

        image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.im1);


    }
}
