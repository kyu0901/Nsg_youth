package com.kyu.user.nsgprac2.Pray;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class getNum extends AsyncTask<Object, Void, String> {

    String TextHolder = "", TextHolder2 = "";
    BufferedReader bufferedReader;


    @Override
    protected String doInBackground(Object... params) {
        try{
            String getMyTxt = (String) params[0];
            URL url2 = new URL((String) params[1]);
            bufferedReader = new BufferedReader(new InputStreamReader(url2.openStream()));
            while((TextHolder2 = bufferedReader.readLine()) != null){
                TextHolder += TextHolder2;
            }
            bufferedReader.close();
        } catch (MalformedURLException malfformedURLException){
            malfformedURLException.printStackTrace();
            TextHolder = malfformedURLException.toString();
        } catch (IOException iOException){
            iOException.printStackTrace();
            TextHolder = iOException.toString();
        }

        Log.i("getNum " , TextHolder);
        return TextHolder;
    }

    @Override
    protected void onPostExecute(String finalTextHolder) {
        super.onPostExecute(finalTextHolder);
    }
}