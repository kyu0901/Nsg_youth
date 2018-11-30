package com.kyu.user.nsgprac2.Intro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.kyu.user.nsgprac2.ChosenPage;
import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-08.
 */

public class Intro extends Fragment {

    String name1;
    String name2;

    public Intro(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.intro, container, false);

        Log.i("fragment : ", "intro");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("intro")){
            Log.i("name2 is ", "first");
            setContentFragment(name2);
        }else {
            Log.i("name2 ", " is change");
            name2 = "intro_ch";
            setContentFragment("intro_ch");
        }
        final Button btn_ch_intro, btn_ws_intro, btn_pastor_intro, btn_team_intro;
        final ImageButton btn_right_tri;

        btn_ch_intro = (Button) view.findViewById(R.id.btn_ch_intro);
        btn_ws_intro = (Button) view.findViewById(R.id.btn_ws_intro);
        btn_pastor_intro = (Button) view.findViewById(R.id.btn_pastor_intro);
        btn_team_intro = (Button) view.findViewById(R.id.btn_team_intro);
        btn_right_tri = (ImageButton) view.findViewById(R.id.btn_right);


        Log.i("name2 : " , name2);
        switch (name2){
            case "intro_ch" :
                Log.i("name2 is ", name2);
                btn_ch_intro.setTextColor(Color.BLACK);
                break;
            case "intro_ws" :
                btn_ws_intro.setTextColor(Color.BLACK);
                break;
            case "intro_pastor" :
                btn_pastor_intro.setTextColor(Color.BLACK);
                break;
            case "intro_team" :
                btn_team_intro.setTextColor(Color.BLACK);
                break;
        }

        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_ch_intro.setTextColor(Color.GRAY);
                btn_ws_intro.setTextColor(Color.GRAY);
                btn_pastor_intro.setTextColor(Color.GRAY);
                btn_team_intro.setTextColor(Color.GRAY);

                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);

                switch (v.getId()){
                    case R.id.btn_ch_intro :
                        btn_ch_intro.setTextColor(Color.BLACK);
                        //setContentFragment("intro_ch");
                        Log.i("intro : ", "btn_ch_intro click");
                        intent_chosen_page.putExtra("name","intro");
                        intent_chosen_page.putExtra("name2", "intro_ch");
                        startActivity(intent_chosen_page);
                        btn_ch_intro.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_ws_intro :
                        btn_ws_intro.setTextColor(Color.BLACK);
                        //setContentFragment("intro_ws");
                        intent_chosen_page.putExtra("name","intro");
                        intent_chosen_page.putExtra("name2", "intro_ws");
                        startActivity(intent_chosen_page);
                        btn_ws_intro.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_pastor_intro :
                        btn_pastor_intro.setTextColor(Color.BLACK);
                        //setContentFragment("intro_pastor");
                        intent_chosen_page.putExtra("name","intro");
                        intent_chosen_page.putExtra("name2", "intro_pastor");
                        startActivity(intent_chosen_page);
                        btn_pastor_intro.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_team_intro :
                        btn_team_intro.setTextColor(Color.BLACK);
                        //setContentFragment("intro_team");
                        intent_chosen_page.putExtra("name","intro");
                        intent_chosen_page.putExtra("name2", "intro_team");
                        startActivity(intent_chosen_page);
                        btn_team_intro.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_right :
                        intent_chosen_page.putExtra("name","intro2");
                        intent_chosen_page.putExtra("name2", "intro_circle");
                        startActivity(intent_chosen_page);
                        break;

                }

                switch (name2){
                    case "intro_ch" :
                        Log.i("name2 is ", name2);
                        btn_ch_intro.setTextColor(Color.BLACK);
                        break;
                    case "intro_ws" :
                        btn_ws_intro.setTextColor(Color.BLACK);
                        break;
                    case "intro_pastor" :
                        btn_pastor_intro.setTextColor(Color.BLACK);
                        break;
                    case "intro_team" :
                        btn_team_intro.setTextColor(Color.BLACK);
                        break;
                }
            }
        };

        btn_ch_intro.setOnClickListener(clickListener);
        btn_ws_intro.setOnClickListener(clickListener);
        btn_pastor_intro.setOnClickListener(clickListener);
        btn_team_intro.setOnClickListener(clickListener);
        btn_right_tri.setOnClickListener(clickListener);

        return view;
    }

    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();


        if(content==null) {
            content = "intro_ch";
            name2 = "intro_ch";
        }

        switch (content){
            case "intro_ch":
                //intro 호출
                ch_intro ch_intro = new ch_intro();
                transaction.replace(R.id.content_layout, ch_intro);
                Log.i("intro_ch", "is commit");
                transaction.commit();
                break;
            case "intro_ws":
                //intro 호출
                ws_intro ws_intro = new ws_intro();
                transaction.replace(R.id.content_layout, ws_intro);
                transaction.commit();
                break;
            case "intro_pastor":
                //intro 호출
                pastor_intro pastor_intro = new pastor_intro();
                transaction.replace(R.id.content_layout, pastor_intro);
                transaction.commit();
                break;
            case "intro_team":
                //intro 호출
                team_intro team_intro = new team_intro();
                transaction.replace(R.id.content_layout, team_intro);
                transaction.commit();
                break;
            case "intro_circle":
                //intro 호출
                circle_intro circle_intro = new circle_intro();
                transaction.replace(R.id.content_layout, circle_intro);
                transaction.commit();
                break;
            case "intro_new_family_reg":
                //intro 호출
                new_family_reg new_family_reg = new new_family_reg();
                transaction.replace(R.id.content_layout, new_family_reg);
                transaction.commit();
                break;

        }
    }
}
