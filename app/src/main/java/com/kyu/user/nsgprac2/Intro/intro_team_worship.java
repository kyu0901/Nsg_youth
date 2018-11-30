package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kyu.user.nsgprac2.R;

public class intro_team_worship extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/team_intro/";

    ImageView img_worship_team;
    getImage get_worship_team_Image;

    public intro_team_worship() {
        get_worship_team_Image = new getImage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intro_team_worship, container, false);

        img_worship_team =  view.findViewById(R.id.imageView);
        get_worship_team_Image.execute(img_worship_team, imgUrl + "worship.png");

        return view;
    }
}
