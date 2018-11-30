package com.kyu.user.nsgprac2.Worship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-21.
 */

//문제점 : 가끔 못 받아오는 경우가 생김.

public class ws_joseph extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/worship/joseph_worship/";

    ImageView img_joseph;
    getImage get_joseph_Image;

    TextView txt_joseph_vision, txt_joseph_ministry;
    getText get_joseph_vision, get_joseph_ministry;


    public ws_joseph() {

        get_joseph_Image = new getImage();

        get_joseph_Image = new getImage();
        get_joseph_vision = new getText();
        get_joseph_ministry = new getText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ws_joseph, container, false);


        img_joseph = (ImageView) view.findViewById(R.id.img_joseph);
        get_joseph_Image.execute(img_joseph, Url + "joseph.png");

        txt_joseph_vision = (TextView) view.findViewById(R.id.txt_joseph_vision);
        get_joseph_vision.execute(txt_joseph_vision, Url + "joseph_vision.txt");

        txt_joseph_ministry = (TextView) view.findViewById(R.id.txt_joseph_ministry);
        get_joseph_ministry.execute(txt_joseph_ministry, Url + "joseph_ministry.txt");


        return view;
    }

}
