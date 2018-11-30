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

public class Intro2 extends Fragment {

    String name1;
    String name2;

    public Intro2(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.intro2, container, false);

        Log.i("This is " , "Intro2");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("intro2")){
            Log.i("name2 is ", "first");
            setContentFragment(name2);
        }else {
            Log.i("name2 ", " is change");
            name2 = "intro_circle";
            setContentFragment("intro_circle");
        }
        final Button btn_circle_intro, btn_new_family_reg;
        final ImageButton btn_left_tri;

        btn_circle_intro = (Button) view.findViewById(R.id.btn_circle_intro);
        btn_new_family_reg = (Button) view.findViewById(R.id.btn_new_family_reg);
        btn_left_tri = (ImageButton) view.findViewById(R.id.btn_left);


        Log.i("name2 : " , name2);
        switch (name2){
            case "intro_circle" :
                btn_circle_intro.setTextColor(Color.BLACK);
                break;
            case "intro_new_family_reg" :
                btn_new_family_reg.setTextColor(Color.BLACK);
                break;
        }


        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_circle_intro.setTextColor(Color.GRAY);
                btn_new_family_reg.setTextColor(Color.GRAY);
                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);
                switch (v.getId()){
                    case R.id.btn_circle_intro :
                        btn_circle_intro.setTextColor(Color.BLACK);
                        //setContentFragment("intro_circle");
                        intent_chosen_page.putExtra("name","intro2");
                        intent_chosen_page.putExtra("name2", "intro_circle");
                        startActivity(intent_chosen_page);
                        btn_circle_intro.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_new_family_reg :
                        btn_new_family_reg.setTextColor(Color.BLACK);
                       //setContentFragment("intro_new_family_reg");
                        intent_chosen_page.putExtra("name","intro2");
                        intent_chosen_page.putExtra("name2", "intro_new_family_reg");
                        startActivity(intent_chosen_page);
                        btn_new_family_reg.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_left :
                        intent_chosen_page.putExtra("name","intro");
                        intent_chosen_page.putExtra("name2", "intro_ch");
                        startActivity(intent_chosen_page);
                        break;

                }
                switch (name2){
                    case "intro_circle" :
                        btn_circle_intro.setTextColor(Color.BLACK);
                        break;
                    case "intro_new_family_reg" :
                        btn_new_family_reg.setTextColor(Color.BLACK);
                        break;
                }
            }
        };


        btn_circle_intro.setOnClickListener(clickListener);
        btn_new_family_reg.setOnClickListener(clickListener);
        btn_left_tri.setOnClickListener(clickListener);

        return view;
    }

    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(content==null) {
            content = "intro_circle";
            name2 = "intro_circle";
        }

        switch (content){
            case "intro_circle":
                //intro 호출
                Log.i("setContentFragment " , "intro_circle");
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
