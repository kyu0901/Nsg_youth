package com.kyu.user.nsgprac2.Worship;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class getText extends AsyncTask<Object, Void, Void> {

    private TextView getMyTxt;
    String TextHolder = "", TextHolder2 = "";
    BufferedReader bufferedReader;


    @Override
    protected Void doInBackground(Object... params) {
        try{
            getMyTxt = (TextView) params[0];
            URL url2 = new URL((String) params[1]);
            bufferedReader = new BufferedReader(new InputStreamReader(url2.openStream()));
            while((TextHolder2 = bufferedReader.readLine()) != null){
                TextHolder += TextHolder2;
                TextHolder += "\n";
            }
            bufferedReader.close();
        } catch (MalformedURLException malfformedURLException){
            malfformedURLException.printStackTrace();
            TextHolder = malfformedURLException.toString();
        } catch (IOException iOException){
            iOException.printStackTrace();
            TextHolder = iOException.toString();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void finalTextHolder) {
        getMyTxt.setText(TextHolder);
        super.onPostExecute(finalTextHolder);
    }
}