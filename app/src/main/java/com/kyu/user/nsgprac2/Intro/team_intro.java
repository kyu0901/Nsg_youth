package com.kyu.user.nsgprac2.Intro;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-21.
 */

public class team_intro extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/team_intro/";

    //우리가 사용할 ImageView들 선언해주기~~~
    ImageView img_gpt;
    getImage get_gpt_Image;

    ImageView img_tbm;
    getImage get_tbm_Image;

    ImageView img_military_team;
    getImage get_military_team_Image;

    ImageView img_advertising_team;
    getImage get_advertising_team_Image;

    ImageView img_diaspora;
    getImage get_diaspora_Image;

    ImageView img_design_team;
    getImage get_design_team_Image;

    ImageView img_media_team;
    getImage get_media_team_Image;

    ImageView img_mission_team;
    getImage get_mission_team_Image;

    ImageView img_new_family;
    getImage get_new_family_Image;

    ImageView img_worship_team;
    getImage get_worship_team_Image;

    ImageView img_joseph;
    getImage get_joseph_Image;

    ImageView img_sat_morn_pray;
    getImage get_sat_morn_pray_Image;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //이것도 차례대로 선언해주기~~ 앞에 이름들만 바꿔주고 new getImage()는 그대로 사용
        get_gpt_Image = new getImage();
        get_tbm_Image = new getImage();
        get_military_team_Image = new getImage();
        get_advertising_team_Image = new getImage();
        get_diaspora_Image = new getImage();
        get_design_team_Image = new getImage();
        get_media_team_Image = new getImage();
        get_mission_team_Image = new getImage();
        get_new_family_Image = new getImage();
        get_worship_team_Image = new getImage();
        get_joseph_Image = new getImage();
        get_sat_morn_pray_Image = new getImage();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("Team_intro ", "why?");
        View view = inflater.inflate(R.layout.intro_team, container, false);
        Log.i("Team_intro ", "why!!!!!");

        //이것처럼 다른 것들도 해주기 ~ .
        img_gpt = (ImageView) view.findViewById(R.id.img_gpt);
        get_gpt_Image.execute(img_gpt, imgUrl + "gpt.png");

        img_tbm = (ImageView) view.findViewById(R.id.img_tbm);
        get_tbm_Image.execute(img_tbm, imgUrl + "tbm.png");

        img_military_team = (ImageView) view.findViewById(R.id.img_military_team);
        get_military_team_Image.execute(img_military_team, imgUrl + "military.png");

        img_advertising_team = (ImageView) view.findViewById(R.id.img_advertising_team);
        get_advertising_team_Image.execute(img_advertising_team, imgUrl + "advertising.png");

        img_diaspora = (ImageView) view.findViewById(R.id.img_diaspora);
        get_diaspora_Image.execute(img_diaspora, imgUrl + "diaspora.png");

        img_design_team = (ImageView) view.findViewById(R.id.img_design_team);
        get_design_team_Image.execute(img_design_team, imgUrl + "design.png");

        img_media_team = (ImageView) view.findViewById(R.id.img_media_team);
        get_media_team_Image.execute(img_media_team, imgUrl + "media.png");

        img_mission_team = (ImageView) view.findViewById(R.id.img_mission_team);
        get_mission_team_Image.execute(img_mission_team, imgUrl + "mission.png");

        img_new_family = (ImageView) view.findViewById(R.id.img_new_family);
        get_new_family_Image.execute(img_new_family, imgUrl + "new_family.png");

        img_worship_team = (ImageView) view.findViewById(R.id.img_worship_team);
        get_worship_team_Image.execute(img_worship_team, imgUrl + "worship.png");

        img_joseph = (ImageView) view.findViewById(R.id.img_joseph);
        get_joseph_Image.execute(img_joseph, imgUrl + "joseph.png");

        img_sat_morn_pray = (ImageView) view.findViewById(R.id.img_sat_morn_pray);
        get_sat_morn_pray_Image.execute(img_sat_morn_pray, imgUrl + "sat_morn.png");


/*
        ImageView joseph_img = (ImageView) view.findViewById(R.id.joseph_img);
        ((BitmapDrawable)joseph_img.getDrawable()).getBitmap().recycle();
        joseph_img.setBackgroundResource(R.drawable.joseph);
*/
        final ImageButton btn_joseph;
        final ImageButton btn_advertising_team;
        final ImageButton btn_diaspora;
        final ImageButton btn_media_team;
        final ImageButton btn_new_family;
        final ImageButton btn_worship_team;

        btn_advertising_team = (ImageButton) view.findViewById(R.id.btn_advertising_team);
        btn_diaspora = (ImageButton) view.findViewById(R.id.btn_diaspora);
        btn_media_team = (ImageButton) view.findViewById(R.id.btn_media_team);
        btn_new_family = (ImageButton) view.findViewById(R.id.btn_new_family);
        btn_worship_team = (ImageButton) view.findViewById(R.id.btn_worship_team);


        ImageButton.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_advertising_team :
                        setContentFragment("btn_advertising_team");
                        Log.i("msg : " ,"btn_advertising_team is clicked");
                        break;
                    case R.id.btn_diaspora :
                        setContentFragment("btn_diaspora");
                        break;
                    case R.id.btn_media_team :
                        setContentFragment("btn_media_team");
                        break;
                    case R.id.btn_new_family :
                        setContentFragment("btn_new_family");
                        break;
                    case R.id.btn_worship_team :
                        setContentFragment("btn_worship_team");
                        break;
                }
            }
        };

        btn_advertising_team.setOnClickListener(clickListener);
        btn_diaspora.setOnClickListener(clickListener);
        btn_media_team.setOnClickListener(clickListener);
        btn_new_family.setOnClickListener(clickListener);
        btn_worship_team.setOnClickListener(clickListener);

        return view;
    }

    private void setContentFragment(String content) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        RelativeLayout rv = (RelativeLayout) getActivity().findViewById(R.id.intro_team_main);
        rv.removeAllViews();

        Log.i("msg : ", content);
        switch (content) {
            case "btn_joseph":
                Log.i("team_intro", " btn_joseph");
                intro_team_joseph intro_team_joseph = new intro_team_joseph();
                transaction.replace(R.id.intro_team_main, intro_team_joseph);
                transaction.commit();
                break;

            case "btn_advertising_team":
                Log.i("team_intro", " btn_advertising_team");
                intro_team_advertise intro_team_advertise = new intro_team_advertise();
                transaction.replace(R.id.intro_team_main, intro_team_advertise);
                transaction.commit();
                break;

            case "btn_diaspora":
                Log.i("team_intro", " btn_diaspora");
                intro_team_diaspora intro_team_diaspora = new intro_team_diaspora();
                transaction.replace(R.id.intro_team_main, intro_team_diaspora);
                transaction.commit();
                break;

            case "btn_media_team":
                Log.i("team_intro", " btn_media_team");
                intro_team_media intro_team_media = new intro_team_media();
                transaction.replace(R.id.intro_team_main, intro_team_media);
                transaction.commit();
                break;

            case "btn_new_family":
                Log.i("team_intro", " in switch");
                intro_team_new_family intro_team_new_family = new intro_team_new_family();
                transaction.replace(R.id.intro_team_main, intro_team_new_family);
                transaction.commit();
                break;

            case "btn_worship_team":
                Log.i("team_intro", " in switch");
                intro_team_worship intro_team_worship = new intro_team_worship();
                transaction.replace(R.id.intro_team_main, intro_team_worship);
                transaction.commit();
                break;


        }
    }
}


