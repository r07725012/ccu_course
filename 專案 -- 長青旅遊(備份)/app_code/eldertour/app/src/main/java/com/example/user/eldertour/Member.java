package com.example.user.eldertour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by user on 2017/2/18.
 */

public class Member extends AppCompatActivity {


    private Button member_login;
    private Button become_member;
    private Button modifying_member_info;
    private Button personal_setting;
    private Button member_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

        member_login = (Button) findViewById(R.id.member_login);
//        become_member = (Button) findViewById(R.id.become_member);
        modifying_member_info = (Button) findViewById(R.id.modifying_member_info);
        personal_setting = (Button) findViewById(R.id.personal_setting);


        member_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Member.this, MemberFirstLogin.class);
                startActivity(intent);
            }
        });

        modifying_member_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Member.this, MemberNonFirstInfoModifying.class);
                startActivity(intent);
            }
        });
        personal_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Member.this, MemberNonFirstPersonal.class);
                //開啟另一個Activity
                startActivity(intent);
            }
        });
//        member_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(true){
//                    // TODO: 2017/3/4 有登入的會員的才會執行
//
//                    Toast.makeText(Member.this,"您已登出",Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(Member.this,"您尚未登入",Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });
//    }
//    @Override
//    public void onResume()
//    {
//        super.onResume();
//        if(member_login.getText().equals("登出")){
//            member_login.setText("會員登入");
//
//        }
//
    }

}
