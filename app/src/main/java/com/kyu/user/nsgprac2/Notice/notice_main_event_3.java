package com.kyu.user.nsgprac2.Notice;

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

public class notice_main_event_3 extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/notice/main_event/main_event_3/";

    PhotoView img_event_1, img_event_2, img_event_3, img_event_4, img_event_5;
    getImage get_event_Image1, get_event_Image2, get_event_Image3, get_event_Image4, get_event_Image5;

    public notice_main_event_3(){

        get_event_Image1 = new getImage();
        get_event_Image2 = new getImage();
        get_event_Image3 = new getImage();
        get_event_Image4 = new getImage();
        get_event_Image5 = new getImage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.notice_main_event1, container, false);

        img_event_1 = (PhotoView) view.findViewById(R.id.img_event_1);
        get_event_Image1.execute(img_event_1, Url + "img_event_1.jpeg");

        img_event_2 = (PhotoView) view.findViewById(R.id.img_event_2);
        get_event_Image2.execute(img_event_2, Url + "img_event_2.jpeg");

        img_event_3 = (PhotoView) view.findViewById(R.id.img_event_3);
        get_event_Image3.execute(img_event_3, Url + "img_event_3.jpeg");

        img_event_4 = (PhotoView) view.findViewById(R.id.img_event_4);
        get_event_Image4.execute(img_event_4, Url + "img_event_4.jpeg");

        img_event_5 = (PhotoView) view.findViewById(R.id.img_event_5);
        get_event_Image5.execute(img_event_5, Url + "img_event_5.jpeg");

        return view;
    }

}
