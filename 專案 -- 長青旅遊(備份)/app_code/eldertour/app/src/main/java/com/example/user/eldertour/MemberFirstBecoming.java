package com.example.user.eldertour;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by user on 2017/2/19.
 */

public class MemberFirstBecoming extends AppCompatActivity
{
    private EditText setAccount;
    private EditText setPassword;
    private EditText setName;

    private String sex;
    private RadioGroup rgroup_sex;
    private EditText setPhone;
    private EditText setEmail;

    private Button become_member_button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_first_becoming);

        setAccount = (EditText) findViewById(R.id.set_account_text); // receive user input
        setPassword = (EditText) findViewById(R.id.set_password_text);
        setName = (EditText) findViewById(R.id.set_name_text);
        rgroup_sex = (RadioGroup) findViewById(R.id.rgroup_sex);
        //rgroup.setOnCheckedChangeListener(listener);
        setPhone = (EditText) findViewById(R.id.set_phone_text);
        setEmail = (EditText) findViewById(R.id.set_email_text);

        become_member_button = (Button) findViewById(R.id.become_member_button);
        become_member_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                switch (rgroup_sex.getCheckedRadioButtonId())
                {
                    case R.id.male_radio:
                        sex="男";
                        break;
                    case R.id.female_radio:
                        sex="女";
                        break;
                }

                AddToMember();
            }
        });

    }


    private void AddToMember(){
        final String setacc = setAccount.getText().toString().trim();  //  receive app data
        final String setpsd = setPassword.getText().toString().trim();
        final String setname = setName.getText().toString().trim();
        final String setsex = sex;
        final String setphone = setPhone.getText().toString().trim();
        final String setemail = setEmail.getText().toString().trim();

        class BecomeMember extends AsyncTask<Void,Void,String>
        {

            ProgressDialog loading;

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
                loading = ProgressDialog.show(MemberFirstBecoming.this,"加入中...","請稍等...",false,false);
            }

            @Override
            protected void onPostExecute(String s)
            {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MemberFirstBecoming.this,s,Toast.LENGTH_LONG).show();
                finish();

            }

            @Override
            protected String doInBackground(Void... v)
            {
                HashMap<String,String> params = new HashMap<>();// package all data at one time
                params.put(Config.KEY_MEMBER_ACCOUNT,setacc);// Config.KEY_MEMBER_ACCOUNT == account
                params.put(Config.KEY_MEMBER_PASSWORD,setpsd);
                params.put(Config.KEY_MEMBER_NAME,setname);
                params.put(Config.KEY_MEMBER_SEX,setsex);
                params.put(Config.KEY_MEMBER_PHONE,setphone);
                params.put(Config.KEY_MEMBER_EMAIL,setemail);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_BECOME_MEMBER, params);// transfer to php
                return res;
            }
        }

        BecomeMember become_member = new BecomeMember();
        become_member.execute();
    }

}
