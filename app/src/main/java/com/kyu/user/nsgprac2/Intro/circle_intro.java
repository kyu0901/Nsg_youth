package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
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

public class circle_intro extends Fragment {

    String imgUrl = "http://220.230.125.167/Nsg_Img/Intro/circle_intro/";

    ImageView img_eating_word_circle;
    getImage get_eating_word_circle_Image;

    ImageView img_daily_morn_pray_circle;
    getImage get_daily_morn_pray_circle_Image;

    ImageView img_youth_right_knowledge_circle;
    getImage get_youth_right_knowledge_circle_Image;



    public circle_intro(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.intro_circle, container, false);

        get_eating_word_circle_Image = new getImage();
        get_daily_morn_pray_circle_Image = new getImage();
        get_youth_right_knowledge_circle_Image = new getImage();

        img_eating_word_circle = (ImageView) view.findViewById(R.id.img_eating_word_circle);
        get_eating_word_circle_Image.execute(img_eating_word_circle, imgUrl+"eating_word.png" );

        img_daily_morn_pray_circle = (ImageView) view.findViewById(R.id.img_daily_morn_pray_circle);
        get_daily_morn_pray_circle_Image.execute(img_daily_morn_pray_circle, imgUrl+"daily_morn_pray.png" );

        img_youth_right_knowledge_circle = (ImageView) view.findViewById(R.id.img_youth_right_knowledge_circle);
        get_youth_right_knowledge_circle_Image.execute(img_youth_right_knowledge_circle, imgUrl+"youth_right_knowledge.png" );


        final ImageButton btn_daily_morn_pray_circle;
        final ImageButton btn_youth_right_knowledge_circle;

        btn_daily_morn_pray_circle = (ImageButton) view.findViewById(R.id.btn_daily_morn_pray_circle);
        btn_youth_right_knowledge_circle = (ImageButton) view.findViewById(R.id.btn_youth_right_knowledge_circle);

        ImageButton.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_daily_morn_pray_circle:
                        setContentFragment("btn_daily_morn_pray_circle");
                        Log.i("msg : ", "btn_daily_morn_pray_circle is clicked");
                        break;
                    case R.id.btn_youth_right_knowledge_circle:
                        setContentFragment("btn_youth_right_knowledge_circle");
                        break;

                }
            }
        };

        btn_daily_morn_pray_circle.setOnClickListener(clickListener);
        btn_youth_right_knowledge_circle.setOnClickListener(clickListener);
        return view;
    }




    private void setContentFragment(String content) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        RelativeLayout rv = (RelativeLayout) getActivity().findViewById(R.id.intro_circle_main);
        rv.removeAllViews();

        Log.i("msg : ", content);
        switch (content) {
            case "btn_daily_morn_pray_circle":
                Log.i("circle_intro", " btn_daily_morn_pray_circle");
                intro_circle_daily_morn_pray intro_circle_daily_morn_pray = new intro_circle_daily_morn_pray();
                transaction.replace(R.id.intro_circle_main, intro_circle_daily_morn_pray);
                transaction.commit();
                break;

            case "btn_youth_right_knowledge_circle":
                Log.i("circle_intro", " btn_youth_right_knowledge_circle");
                intro_circle_youth_right_knowledge intro_circle_youth_right_knowledge = new intro_circle_youth_right_knowledge();
                transaction.replace(R.id.intro_circle_main, intro_circle_youth_right_knowledge);
                transaction.commit();
                break;
        }
    }

}
