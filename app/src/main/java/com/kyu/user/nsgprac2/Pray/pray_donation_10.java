package com.kyu.user.nsgprac2.Pray;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kyu.user.nsgprac2.R;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * Created by hyk on 2018-02-21.
 */

public class pray_donation_10 extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/pray/support_pray/pray_donation_10/";

    PhotoView img_donation_1, img_donation_2, img_donation_3, img_donation_4, img_donation_5,
            img_donation_6, img_donation_7, img_donation_8, img_donation_9, img_donation_10;
    getImage get_donation_Image1, get_donation_Image2, get_donation_Image3, get_donation_Image4, get_donation_Image5,
            get_donation_Image6, get_donation_Image7, get_donation_Image8, get_donation_Image9, get_donation_Image10;
    TextView txt_donation_1;
    getText2 get_txt_donation_1;

    public pray_donation_10(){

        get_donation_Image1 = new getImage();
        get_donation_Image2 = new getImage();
        get_donation_Image3 = new getImage();
        get_donation_Image4 = new getImage();
        get_donation_Image5 = new getImage();
        get_donation_Image6 = new getImage();
        get_donation_Image7 = new getImage();
        get_donation_Image8 = new getImage();
        get_donation_Image9 = new getImage();
        get_donation_Image10 = new getImage();

        get_txt_donation_1 = new getText2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pray_donation1, container, false);

        Log.i("msg: " , " pray_donation_10");

        txt_donation_1 = (TextView) view.findViewById(R.id.txt_pray_donation);
        get_txt_donation_1.execute(txt_donation_1, Url + "pray_donation.txt");

        img_donation_1 = (PhotoView) view.findViewById(R.id.img_pray_donation_1);
        get_donation_Image1.execute(img_donation_1, Url + "page1.jpeg");

        img_donation_2 = (PhotoView) view.findViewById(R.id.img_pray_donation_2);
        get_donation_Image2.execute(img_donation_2, Url + "page2.jpeg");

        img_donation_3 = (PhotoView) view.findViewById(R.id.img_pray_donation_3);
        get_donation_Image3.execute(img_donation_3, Url + "page3.jpeg");

        img_donation_4 = (PhotoView) view.findViewById(R.id.img_pray_donation_4);
        get_donation_Image4.execute(img_donation_4, Url + "page4.jpeg");

        img_donation_5 = (PhotoView) view.findViewById(R.id.img_pray_donation_5);
        get_donation_Image5.execute(img_donation_5, Url + "page5.jpeg");

        img_donation_6 = (PhotoView) view.findViewById(R.id.img_pray_donation_6);
        get_donation_Image6.execute(img_donation_6, Url + "page6.jpeg");

        img_donation_7 = (PhotoView) view.findViewById(R.id.img_pray_donation_7);
        get_donation_Image7.execute(img_donation_7, Url + "page7.jpeg");

        img_donation_8 = (PhotoView) view.findViewById(R.id.img_pray_donation_8);
        get_donation_Image8.execute(img_donation_8, Url + "page8.jpeg");

        img_donation_9 = (PhotoView) view.findViewById(R.id.img_pray_donation_9);
        get_donation_Image9.execute(img_donation_9, Url + "page9.jpeg");

        img_donation_10 = (PhotoView) view.findViewById(R.id.img_pray_donation_10);
        get_donation_Image10.execute(img_donation_10, Url + "page10.jpeg");


        return view;
    }


}
