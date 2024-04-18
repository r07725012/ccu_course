package com.example.user.eldertour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.HashMap;

/**
 * Created by user on 2017/4/24.
 */

public class MemberNonFirstInfoModifying extends AppCompatActivity
{
    private EditText setName;
    private String sex;
    private EditText setPhone;
    private EditText setEmail;
    private RadioGroup rgroup_sex;
    private Button update_member_button;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_nonfirst_info_modifying);

         // receive user input
        setName = (EditText) findViewById(R.id.set_name_text);
        rgroup_sex = (RadioGroup) findViewById(R.id.rgroup_sex);
        setPhone = (EditText) findViewById(R.id.set_phone_text);
        setEmail = (EditText) findViewById(R.id.set_email_text);

        update_member_button = (Button) findViewById(R.id.update_member_button);
        update_member_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (rgroup_sex.getCheckedRadioButtonId())
                {
                    case R.id.male_radio:
                        sex="男";
                        break;
                    case R.id.female_radio:
                        sex="女";
                        break;
                }
                updateMemberInfo();
            }
        });

    }

    private void updateMemberInfo(){
        //  from app input to java
        final String setname = setName.getText().toString().trim();
        final String setsex = sex;
        final String setphone = setPhone.getText().toString().trim();
        final String setemail = setEmail.getText().toString().trim();

        class UpdateMember extends AsyncTask<Void,Void,String>
        {

            ProgressDialog loading;

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
                loading = ProgressDialog.show(MemberNonFirstInfoModifying.this,"加入中...","請稍等...",false,false);
            }

            @Override
            protected void onPostExecute(String s)
            {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MemberNonFirstInfoModifying.this,s,Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.setClass(MemberNonFirstInfoModifying.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            protected String doInBackground(Void... v)
            {
                HashMap<String,String> params = new HashMap<>();// pack age all data at one time

                SharedPreferences pref = getSharedPreferences("myActivityName", 0);
                SharedPreferences.Editor editor = pref.edit();
                //editor.remove("user_name");
                editor.putString("user_name",setname);
                editor.commit();

                params.put(Config.KEY_MEMBER_ACCOUNT,pref.getString("ACCOUNT","failed"));
                params.put(Config.KEY_MEMBER_NAME,setname);
                params.put(Config.KEY_MEMBER_SEX,setsex);
                params.put(Config.KEY_MEMBER_PHONE,setphone);
                params.put(Config.KEY_MEMBER_EMAIL,setemail);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_UPDATE_MEMBER, params);// transfer to php
                return res;
            }
        }

        UpdateMember update_member = new UpdateMember();
        update_member.execute();
    }



}
