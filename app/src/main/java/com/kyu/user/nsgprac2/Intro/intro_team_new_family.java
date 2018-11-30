package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kyu.user.nsgprac2.R;

public class intro_team_new_family extends Fragment{

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/team_intro/";

    ImageView img_new_family, img_new_family2, img_new_family3;
    getImage get_new_family_Image, get_new_family_Image2, get_new_family_Image3;

    public intro_team_new_family() {
        get_new_family_Image = new getImage();
        get_new_family_Image2 = new getImage();
        get_new_family_Image3 = new getImage();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("intro_team_new_family", " in onCreatView");
        View view = inflater.inflate(R.layout.intro_team_new_family, container, false);

        img_new_family = view.findViewById(R.id.imageView);
        get_new_family_Image.execute(img_new_family, imgUrl + "new_family_1.jpg");

        img_new_family2 =  view.findViewById(R.id.imageView2);
        get_new_family_Image2.execute(img_new_family2, imgUrl + "new_family_2.png");

        img_new_family3 =  view.findViewById(R.id.imageView3);
        get_new_family_Image3.execute(img_new_family3, imgUrl + "new_family_3.jpg");

        return view;
    }
}
