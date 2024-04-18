package com.example.user.eldertour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 2017/2/18.
 */

public class MySuit extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView listView;

    private String JSON_STRING;
    private Button detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suit);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
//        getJSON();
        showMySuit();
    }


    private void showMySuit(){
//        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
//        try {
////            jsonObject = new JSONObject(JSON_STRING);
////            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
//
////            for(int i = 0; i<result.length(); i++){
////                JSONObject jo = result.getJSONObject(i);
////                String tour_name = jo.getString(Config.TAG_SUIT_NAME);
////
////
////                HashMap<String,String> suits = new HashMap<>();
////                suits.put(Config.TAG_SUIT_NAME,tour_name);
////                list.add(suits);
////            }
//
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        for(int i = 0; i<10; i++){
//                JSONObject jo = result.getJSONObject(i);
            String [] tour_name = {"擁抱大自然","健康步道行","檜意鐵道趣","環潭賞水舞"};


            HashMap<String,String> suits = new HashMap<>();
            suits.put(Config.TAG_SUIT_NAME,tour_name[i%4]);
            list.add(suits);
        }

        ListAdapter adapter = new SimpleAdapter(
                MySuit.this, list, R.layout.mysuit_list_item,
                new String[]{Config.TAG_SUIT_NAME},
                new int[]{ R.id.suitlayout_hug_nature_textView});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MySuit.this,"Fetching Data","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showMySuit();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_ALL_SUIT);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this, ViewEmployee.class);
//        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
//        String empId = map.get(Config.TAG_ID).toString();
//        intent.putExtra(Config.EMP_ID,empId);
//        startActivity(intent);
        Intent intent = new Intent(this, MySuitItems.class);
        startActivity(intent);
    }
}
