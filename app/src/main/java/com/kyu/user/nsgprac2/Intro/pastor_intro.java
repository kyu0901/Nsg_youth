package com.kyu.user.nsgprac2.Intro;

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

public class pastor_intro extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/pastor_intro/";

    ImageView img_pastor_director;
    getImage get_pastor_director_Image;

    ImageView img_pastor_youth2;
    getImage get_pastor_youth2_Image;

    ImageView img_pastor_youth1;
    getImage get_pastor_youth1_Image;

    ImageView img_pastor_joseph;
    getImage get_pastor_joseph_Image;

    public pastor_intro(){

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intro_pastor, container, false);

        get_pastor_director_Image = new getImage();
        get_pastor_youth2_Image = new getImage();
        get_pastor_youth1_Image = new getImage();
        get_pastor_joseph_Image = new getImage();

        img_pastor_director = (ImageView) view.findViewById(R.id.img_pastor_director);
        get_pastor_director_Image.execute(img_pastor_director, imgUrl+"young_man.jpeg" );

        img_pastor_youth2 = (ImageView) view.findViewById(R.id.img_pastor_youth2);
        get_pastor_youth2_Image.execute(img_pastor_youth2, imgUrl+"young_man_2.jpeg" );

        img_pastor_youth1 = (ImageView) view.findViewById(R.id.img_pastor_youth1);
        get_pastor_youth1_Image.execute(img_pastor_youth1, imgUrl+"young_man_1.jpeg" );

        img_pastor_joseph = (ImageView) view.findViewById(R.id.img_pastor_joseph);
        get_pastor_joseph_Image.execute(img_pastor_joseph, imgUrl+"joseph.jpeg" );




        return view;
    }

}
