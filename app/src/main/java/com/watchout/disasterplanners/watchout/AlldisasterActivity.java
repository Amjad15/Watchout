package com.watchout.disasterplanners.watchout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.watchout.disasterplanners.watchout.disasters.vlocanoActivity;
import com.watchout.disasterplanners.watchout.disasters.duststormActivity;
import com.watchout.disasterplanners.watchout.disasters.thunderstormActivity;
import com.watchout.disasterplanners.watchout.disasters.floodActivity;
import com.watchout.disasterplanners.watchout.disasters.wildfireActivity;
import com.watchout.disasterplanners.watchout.disasters.earthquakeActivity;
import com.watchout.disasterplanners.watchout.disasters.snowstormActivity;


public class AlldisasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldisaster);

        Button vo,th,dus,fl,sno,win, eq,hail;

        vo = (Button) findViewById(R.id.Vbtn);
        th = (Button) findViewById(R.id.Tbtn);
        fl = (Button) findViewById(R.id.Fbtn);
        dus = (Button) findViewById(R.id.Dbtn);
        sno = (Button) findViewById(R.id.Sbtn);
        win = (Button) findViewById(R.id.Wbtn);
        eq = (Button) findViewById(R.id.Ebtn);
        hail = (Button) findViewById(R.id.Hbtn);


        vo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlldisasterActivity.this,vlocanoActivity.class);
                startActivity(i);
            }
        });

        th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlldisasterActivity.this,thunderstormActivity.class);
                startActivity(i);
            }
        });
        dus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlldisasterActivity.this,duststormActivity.class);
                startActivity(i);

            }
        });
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlldisasterActivity.this,floodActivity.class);
                startActivity(i);

            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlldisasterActivity.this,earthquakeActivity.class);
                startActivity(i);
            }
        });
        win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlldisasterActivity.this,wildfireActivity.class);
                startActivity(i);

            }
        });
        sno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlldisasterActivity.this,snowstormActivity.class);
                startActivity(i);

            }
        });



    }
}
