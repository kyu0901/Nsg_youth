package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kyu.user.nsgprac2.R;

public class intro_team_advertise extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/team_intro/";
    ImageView img_advertising_team;
    getImage get_advertising_team_Image;
    public intro_team_advertise() {
        get_advertising_team_Image = new getImage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("intro_team_advertise", " in onCreatView");
        View view = inflater.inflate(R.layout.intro_team_advertise, container, false);

        img_advertising_team = view.findViewById(R.id.imageView);
        get_advertising_team_Image.execute(img_advertising_team, imgUrl + "advertising.png");

        return view;
    }
}
