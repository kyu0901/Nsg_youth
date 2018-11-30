package com.kyu.user.nsgprac2.Worship;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hyk on 2018-07-10.
 */

class getImage extends AsyncTask<Object, Void,Bitmap> {

    private ImageView bmImage;
    Bitmap bmImg;

    @Override
    protected Bitmap doInBackground(Object... params) {
        bmImage = (ImageView) params[0];
        String urls = (String) params[1];
        // TODO Auto-generated method stub
        try{
            URL url = new URL(urls);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoInput(true);
            conn.connect();

            InputStream is = conn.getInputStream();
            bmImg = BitmapFactory.decodeStream(is);


        }catch(IOException e){
            e.printStackTrace();
        }
        return bmImg;
    }

    protected void onPostExecute(Bitmap img){
        bmImage.setImageBitmap(img);
        bmImage.setScaleType(ImageView.ScaleType.FIT_XY);
    }

}
