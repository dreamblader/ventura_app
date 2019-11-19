package com.masterus.ventura_shop.models;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 *
 */
public class APIRequester extends AsyncTask<String,Void, JSONArray>
{

    private static final String TAG = "APIRequester:" ;

    @Override
    protected JSONArray doInBackground(String... params)
    {

        //List<HashMap> jsonList = new ArrayList<>();
        JSONArray result = null;


        try
        {
            URL serviceURL = new URL(params[0]);
            HttpURLConnection httpConnection = (HttpURLConnection) serviceURL.openConnection();
            httpConnection.setRequestProperty("User-Agent", "ventura-shop-app");
            httpConnection.setRequestMethod(params[1]);
            int statusCode = httpConnection.getResponseCode();

            if(statusCode == 200 || statusCode==206)
            {
                Log.d(TAG,"API Connected!");
                InputStream response = httpConnection.getInputStream();
                InputStreamReader responseReader = new InputStreamReader(response, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(responseReader);

                String line="";
                StringBuilder responseString = new StringBuilder();

                while ((line = bufferedReader.readLine())!=null)
                {
                    responseString.append(line);
                }

                JSONTokener jsonTokener = new JSONTokener(responseString.toString());
                result = new JSONArray(jsonTokener);

            }
            else
            {
                throw new RuntimeException("HttpResponseCode: " +statusCode);
            }

            httpConnection.disconnect();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }

        return result;
    }

}
