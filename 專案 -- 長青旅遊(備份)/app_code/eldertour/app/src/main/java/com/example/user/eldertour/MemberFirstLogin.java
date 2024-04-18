package com.example.user.eldertour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import static com.example.user.eldertour.R.id.account_text;


/**
 * Created by user on 2017/2/18.
 */

public class MemberFirstLogin extends AppCompatActivity {

    //Defining views
    private EditText account;
    private EditText password;

    private Button login_button;
    private Button clear_button;
    private Button forgotten_button;
    private Button become_member_botton;

    private SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_first_login);

        //Initializing views

        account = (EditText) findViewById(account_text);
        password = (EditText) findViewById(R.id.password_text);

        login_button = (Button) findViewById(R.id.login_button);
        clear_button = (Button) findViewById(R.id.clear_button);
        forgotten_button = (Button) findViewById(R.id.forgotten_button);
        become_member_botton= (Button) findViewById(R.id.become_member_botton);

        sharedpreferences= PreferenceManager.getDefaultSharedPreferences(this);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
//                sharedpreferences = getSharedPreferences("Preference", 0);
//                //置入name屬性的字串
//                sharedpreferences.edit().putString("account", account.getText().toString().trim()).commit();
//                sharedpreferences.edit().putString("password", password.getText().toString().trim()).commit();
            }
        });

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account.setText("");
                password.setText("");
            }
        });

        forgotten_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //sendEmail();


            }
        });

        become_member_botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MemberFirstLogin.this, MemberFirstBecoming.class);
                startActivity(intent);
            }
        });
    }


    private void Login()
    {
        final String acc = account.getText().toString().trim();  //  receive app data (edittext)
        final String psd = password.getText().toString().trim();

        class CheckLogin extends AsyncTask<Void,Void,String>
        {

            ProgressDialog loading;

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
                loading = ProgressDialog.show(MemberFirstLogin.this,"登入中...","請稍等...",false,false);
            }

            @Override
            protected void onPostExecute(String s) // receive php data
            {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MemberFirstLogin.this,s,Toast.LENGTH_LONG).show(); // print data on app

                if(s.equals("登入成功")){
                    SharedPreferences pref = getSharedPreferences( "myActivityName" ,  0 );
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean( "isFirstIn" ,  false );
                    editor.putString("ACCOUNT", acc);
                    editor.commit();
                    get_user_name();

                } else{
                    account.setText("");
                    password.setText("");
                }


//                setContentView(R.layout.member);
//                Button member_logout = (Button) findViewById(R.id.member_login);
//                member_logout.setText("登出");
            }

            // transfer app data to php
            @Override
            protected String doInBackground(Void... v)
            {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_MEMBER_ACCOUNT,acc);
                params.put(Config.KEY_MEMBER_PASSWORD,psd);
                params.put(Config.KEY_MEMBER_LOGIN,"notLogined");

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_Login, params);
                return res;
            }
        }

        CheckLogin checklogin = new CheckLogin();
        checklogin.execute();
    }


    private void get_user_name(){
        class GetUname extends AsyncTask<Void,Void,String>
        {
            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
            }

            @Override   // s = php echo data
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                SharedPreferences pref = getSharedPreferences("myActivityName", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("user_name", s);
                // return to mainpage
                Intent intent = new Intent();
                intent.setClass(MemberFirstLogin.this, MainActivity.class);
                startActivity(intent);
                editor.commit();
                finish();
            }

            @Override
            protected String doInBackground(Void... v)
            {

                SharedPreferences pref = getSharedPreferences( "myActivityName" ,  0 );

                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_MEMBER_ACCOUNT,pref.getString("ACCOUNT","")); // $_POST['account']  receive
                params.put(Config.KEY_MEMBER_PASSWORD,"");
                params.put(Config.KEY_MEMBER_LOGIN,"logined");

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_Login, params);
                return res;
            }
        }

        GetUname getuname = new GetUname();
        getuname.execute();
    }

    //private void sendEmail()



}