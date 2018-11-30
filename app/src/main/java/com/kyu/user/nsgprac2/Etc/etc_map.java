package com.kyu.user.nsgprac2.Etc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyu.user.nsgprac2.R;
import com.github.chrisbanes.photoview.PhotoView;


/**
 * Created by user on 2018-08-06.
 */
public class etc_map extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/etc/map_etc/";

    PhotoView photoView, photoView2, photoView3;
    getImage get_map_img, get_map_img2, get_map_img3;


    public etc_map() {

        get_map_img = new getImage();
        get_map_img2 = new getImage();
        get_map_img3 = new getImage();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.etc_map, container, false);

        photoView = (PhotoView) view.findViewById(R.id.photo_view);
        get_map_img.execute(photoView, imgUrl + "etc_map.png");

        photoView2 = (PhotoView) view.findViewById(R.id.photo_view2);
        get_map_img2.execute(photoView2, imgUrl + "etc_map2.jpeg");

        photoView3 = (PhotoView) view.findViewById(R.id.photo_view3);
        get_map_img3.execute(photoView3, imgUrl + "etc_map3.jpeg");

        return view;
    }

}
