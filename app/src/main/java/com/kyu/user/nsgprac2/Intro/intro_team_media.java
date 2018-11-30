package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kyu.user.nsgprac2.R;

public class intro_team_media extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/team_intro/";

    ImageView img_media_team;
    getImage get_media_team_Image;

    public intro_team_media() {
        get_media_team_Image = new getImage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intro_team_media, container, false);

        img_media_team = view.findViewById(R.id.imageView);
        get_media_team_Image.execute(img_media_team, imgUrl + "media.png");

        return view;
    }
}
