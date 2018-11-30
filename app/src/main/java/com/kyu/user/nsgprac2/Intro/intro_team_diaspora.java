package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kyu.user.nsgprac2.R;

public class intro_team_diaspora extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/team_intro/";

    ImageView img_diaspora;
    getImage get_diaspora_Image;


    public intro_team_diaspora(){
        get_diaspora_Image = new getImage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intro_team_diaspora, container, false);

        img_diaspora = view.findViewById(R.id.imageView);
        get_diaspora_Image.execute(img_diaspora, imgUrl + "diaspora.png");

        return view;
    }
}
