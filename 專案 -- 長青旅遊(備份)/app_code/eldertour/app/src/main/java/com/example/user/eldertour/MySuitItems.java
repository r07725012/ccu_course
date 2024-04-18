package com.example.user.eldertour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MySuitItems extends AppCompatActivity {

    private Button navigation_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mysuit_layout);

        navigation_button = (Button) findViewById(R.id.navigation_button);

        navigation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent();
                intent.setClass(MySuitItems.this, Poi.class);
                //開啟另一個Activity
                startActivity(intent);
*/
               // Uri gmmIntentUri = Uri.parse("geo:0,0?q= ");
               Uri gmmIntentUri = Uri.parse("google.navigation:q= 阿里山火車站");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }





            }
        });









    }

}
