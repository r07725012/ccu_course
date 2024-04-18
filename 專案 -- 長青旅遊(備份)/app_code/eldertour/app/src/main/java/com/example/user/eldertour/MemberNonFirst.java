package com.example.user.eldertour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 2017/3/12.
 */

public class MemberNonFirst extends AppCompatActivity {
    private Button logout;
    private Button modify_personal;
    private Button condition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_nonfirst);

        logout = (Button) findViewById(R.id.logout);
        modify_personal = (Button) findViewById(R.id.modify_personal);
        condition = (Button) findViewById(R.id.condition);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(MemberNonFirst.this, MainActivity.class);
//                //開啟另一個Activity
//                startActivity(intent);
                SharedPreferences pref = getSharedPreferences( "myActivityName" ,  0 );
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean( "isFirstIn" ,  true );
                editor.remove("ACCOUNT");
                editor.commit();

                //開啟另一個Activity
                Intent intent = new Intent();
                intent.setClass(MemberNonFirst.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        });

        modify_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MemberNonFirst.this, MemberNonFirstInfoModifying.class);
                //開啟modify info page ( MemberNonFirstInfoModifying )
                startActivity(intent);

            }
        });
        condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MemberNonFirst.this, MemberNonFirstCondition.class);
                //開啟另一個Activity
                startActivity(intent);
            }
        });

    }
}
