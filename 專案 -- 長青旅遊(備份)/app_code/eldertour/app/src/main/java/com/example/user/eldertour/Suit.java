package com.example.user.eldertour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by user on 2017/2/18.
 */

public class Suit extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView listView;
    private final String USER_AGENT = "Mozilla/5.0";
    private String JSON_STRING;

    int[] suit_pics = new int[]{
            R.drawable.pic0,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9,
            R.drawable.pic10,
            R.drawable.pic11,
            R.drawable.pic12,
            R.drawable.pic13,
            R.drawable.pic14,
            R.drawable.pic15,
            R.drawable.pic16,
            R.drawable.pic17,
            R.drawable.pic18,
            R.drawable.pic19,
            R.drawable.pic20,
            R.drawable.pic21,
            R.drawable.pic22,
            R.drawable.pic23,
            R.drawable.pic24,
            R.drawable.pic25,
            R.drawable.pic26,
            R.drawable.pic27,
            R.drawable.pic28,
            R.drawable.pic29,
            R.drawable.pic30,
            R.drawable.pic31,
            R.drawable.pic32,
            R.drawable.pic29,
            R.drawable.pic30,
            R.drawable.pic31,
            R.drawable.pic32};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suit);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getjson();
    }


    private void showSuit() {
//        loading = ProgressDialog.show(Suit.this,"Adding...","Wait...",false,false);
        JSONObject jsonObject = null;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        ArrayList<Map<String,String>> list = new ArrayList<Map<String,String >>();

        try {
//            loading = ProgressDialog.show(Suit.this,JSON_STRING,"Wait...",false,false);
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray travellist = jsonObject.getJSONArray("TravelList");

            for (int i = 0; i < travellist.length(); i++) {

                JSONObject suit = travellist.getJSONObject(i);
                String title = suit.getString("title");
                double days = suit.getDouble("days");
                JSONArray recordList = suit.getJSONArray("recordList");

//                HashMap<String,String> suits = new HashMap<>();
                Map<String, Object> suits = new HashMap<String, Object>();

                suits.put(Config.TAG_SUIT_NAME, title);
                suits.put("suit_pic", suit_pics[i]);

                list.add(suits);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        ListAdapter adapter = new SimpleAdapter(
                Suit.this, list, R.layout.suit_list_item,
                new String[]{Config.TAG_SUIT_NAME, Config.TAG_SUIT_PICTURE},
                new int[]{R.id.suitlayout_hug_nature_textView, R.id.suitlayout_nature_imageView}
        ) {
            // TODO: 2017/5/1 沒辦法直接同時有按鈕又有listview的功能-->因此要多個按鈕複寫於此
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {


                View v = super.getView(position, convertView, parent);

                Button navigation_button = (Button) v.findViewById(R.id.navigation_button);
                navigation_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent(Suit.this, SuitItemDetail.class);
                        startActivity(intent);

                    }
                });
                final ImageButton suitlayout_hearts_imageButton = (ImageButton) v.findViewById(R.id.suitlayout_hearts_imageButton);
                suitlayout_hearts_imageButton.setOnClickListener(new View.OnClickListener() {
                    int likecount = 1;

                    @Override
                    public void onClick(View arg0) {
                        if (likecount % 2 == 0) {
                            suitlayout_hearts_imageButton.setImageResource(R.drawable.hearts_empty);
                            likecount++;
                            Toast.makeText(Suit.this, position + "加入我的行程", Toast.LENGTH_SHORT).show(); // print data on app
                        } else {
                            suitlayout_hearts_imageButton.setImageResource(R.drawable.hearts);
                            likecount--;
                        }

                    }
                });

                return v;
            }

        };

        listView.setAdapter(adapter);
    }

    private void getjson() {
        class AddEmployee extends AsyncTask<Void, Void, String> {
            String str;
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Suit.this, "Adding...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showSuit();

            }

            @Override
            protected String doInBackground(Void... v) {
                try {
                    String url = Config.URL_ALL_SUIT;

                    URL obj = new URL(url);
                    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

                    // add reuqest header
                    con.setRequestMethod("POST");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                    String urlParameters = "lang=TW&orderBy=name&start=0&limit=2000";
                    // Send post request
                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(urlParameters);
                    wr.flush();
                    wr.close();
                    int responseCode = con.getResponseCode();
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    JSON_STRING = response.toString();
                } catch (Exception e) {

                }
                return JSON_STRING;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }


}

