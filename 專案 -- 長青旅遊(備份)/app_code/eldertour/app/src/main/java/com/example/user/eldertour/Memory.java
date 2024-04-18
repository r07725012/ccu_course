package com.example.user.eldertour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 2017/2/18.
 */

public class Memory extends AppCompatActivity {
    private Button camera_button;
    private Button filmmaker_button;
    private Button watch_videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory);
        camera_button = (Button) findViewById(R.id.camera_button);
        filmmaker_button = (Button) findViewById(R.id.filmmaker_button);
        watch_videos = (Button) findViewById(R.id.watch_videos);


        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Memory.this, MemoryCamera.class);
                //開啟另一個Activity
                startActivity(intent);


            }
        });

        filmmaker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Memory.this, MemoryFilmMaker.class);
                //開啟另一個Activity
                startActivity(intent);


            }
        });
        watch_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(Memory.this, MemoryFilmMaker.class);
//                //開啟另一個Activity
//                startActivity(intent);
            }
        });
    }
}