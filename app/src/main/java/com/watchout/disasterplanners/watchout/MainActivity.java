package com.watchout.disasterplanners.watchout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnmap = (Button) findViewById(R.id.btnmap);

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tomap = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(tomap);
            }
        });
        Button btnq = (Button) findViewById(R.id.btnq);

        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent tomapp = new Intent(MainActivity.this, NearDisaster.class);
//                startActivity(tomapp);
            }
        });
    }
}
