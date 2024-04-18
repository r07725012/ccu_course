package com.example.user.eldertour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 2017/2/18.
 */

public class MemberNonFirstPersonal extends AppCompatActivity {
    private Button body;
    private Button preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_nonfirst_personal);

        body = (Button) findViewById(R.id.body);
        preference = (Button) findViewById(R.id.preference);



        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MemberNonFirstPersonal.this, MemberNonFirstPersonalBody.class);
                //開啟另一個Activity
                startActivity(intent);
            }
        });

        preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MemberNonFirstPersonal.this, MemberNonFirstCondition.class);
                //開啟另一個Activity
                startActivity(intent);
            }
        });


    }


}
