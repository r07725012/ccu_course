package com.example.user.eldertour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {


    private ImageButton home_page_suit_icon_imageButton;
    private ImageButton home_page_mysuit_icon_imageButton;
    private ImageButton home_page_memory_icon_imageButton;
    private ImageButton home_page_mypoint_icon_imageButton;
    private ImageButton home_page_member_icon_imageButton;
    private Button home_page_member_icon_Button;

    private Boolean isFirstIn = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 2017/3/13 抓介面
        setContentView(R.layout.main_page);

        home_page_suit_icon_imageButton = (ImageButton) findViewById(R.id.home_page_suit_icon_imageButton);
        home_page_mysuit_icon_imageButton = (ImageButton) findViewById(R.id.home_page_mysuit_icon_imageButton);
        home_page_memory_icon_imageButton = (ImageButton) findViewById(R.id.home_page_memory_icon_imageButton);
        home_page_mypoint_icon_imageButton = (ImageButton) findViewById(R.id.home_page_mypoint_icon_imageButton);
        home_page_member_icon_imageButton = (ImageButton) findViewById(R.id.home_page_member_icon_imageButton);
        home_page_member_icon_Button = (Button) findViewById(R.id.button2);


        home_page_member_icon_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent();
                intent.setClass(MainActivity.this, MapsActivity.class);
                //開啟另一個Activity
                startActivity(intent);
*/
                //  from one assigned place to another
                double startLatitude = 24.772018;
                double startLongitude = 121.002129;

                double endLatitude = 24.7909902;
                double endLongitude = 121.0024402;

                String saddr = "saddr=" + startLatitude + "," + startLongitude;
                String daddr = "daddr=" + endLatitude + "," + endLongitude;
                String uriString = "http://maps.google.com/maps?" + saddr + "&" + daddr;

                Uri uri = Uri.parse(uriString);

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);

                // If you want to get rid of the dialog,
                // Before the startActivity() add this
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

                startActivity(intent);



            }
        });


        home_page_suit_icon_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent();
                intent.setClass(MainActivity.this, Suit.class);
                //開啟另一個Activity
                startActivity(intent);*/
                //導航
                Uri gmmIntentUri = Uri.parse("google.navigation:q=24.7909902, 121.0024402");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


            }
        });

        home_page_mysuit_icon_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MySuit.class);
                //開啟另一個Activity
                startActivity(intent);
            }
        });

        home_page_memory_icon_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Memory.class);
                //開啟另一個Activity
                startActivity(intent);
            }
        });
        home_page_mypoint_icon_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyPoint.class);
                //開啟另一個Activity
                startActivity(intent);
            }
        });
        home_page_member_icon_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                SharedPreferences pref = getSharedPreferences("myActivityName", 0);
                //取得相应的值，如果没有该值，说明还未写入，用true作为默认值
                isFirstIn = pref.getBoolean("isFirstIn", true);



                if(isFirstIn){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MemberFirstLogin.class);
                    //開啟另一個Activity
                    startActivity(intent);
                }else {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MemberNonFirst.class);
                    //開啟另一個Activity
                    startActivity(intent);
                }






            }
        });
    }
}
