package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyu.user.nsgprac2.R;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * Created by hyk on 2018-02-21.
 */

public class ws_intro extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/ws_intro/";
    PhotoView img_ws_intro_1, img_ws_intro_2, img_ws_intro_3;
    getImage get_intro_img_1, get_intro_img_2, get_intro_img_3;


    public ws_intro(){

        get_intro_img_1 = new getImage();
        get_intro_img_2 = new getImage();
        get_intro_img_3 = new getImage();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intro_ws , container, false);

        img_ws_intro_1 = (PhotoView) view.findViewById(R.id.img_ws_intro_1);
        get_intro_img_1.execute(img_ws_intro_1, imgUrl + "ws_intro_1.PNG");

        img_ws_intro_2 = (PhotoView) view.findViewById(R.id.img_ws_intro_2);
        get_intro_img_2.execute(img_ws_intro_2, imgUrl + "ws_intro_2.jpg");

        img_ws_intro_3 = (PhotoView) view.findViewById(R.id.img_ws_intro_3);
        get_intro_img_3.execute(img_ws_intro_3, imgUrl + "ws_intro_3.jpg");


        return view;
    }


}
