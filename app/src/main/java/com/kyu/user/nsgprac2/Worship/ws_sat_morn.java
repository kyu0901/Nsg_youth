package com.kyu.user.nsgprac2.Worship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-21.
 */

public class ws_sat_morn extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/worship/sat_worship/";

    ImageView img_sat_morn;
    getImage get_sat_morn_Image;

    public ws_sat_morn(){
        get_sat_morn_Image = new getImage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ws_sat_morn, container, false);

        img_sat_morn = (ImageView) view.findViewById(R.id.img_sat_morn);
        get_sat_morn_Image.execute(img_sat_morn, Url+"sat.png" );

        return view;
    }
}
