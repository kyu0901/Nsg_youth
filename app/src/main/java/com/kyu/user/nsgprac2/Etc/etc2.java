package com.kyu.user.nsgprac2.Etc;

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

public class etc2 extends Fragment {

    String name1;
    String name2;

    public etc2(){



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.etc2, container, false);

        Log.i("fragment : ", "etc");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("etc2")){
            Log.i("etc ", "etc page is first");
            setContentFragment(name2);
        }else {
            Log.i("etc ", "name2 is change");
            name2 = "map";
            setContentFragment("map");
        }

        //버튼 선언
        final Button btn_map, btn_app_upload, btn_suggestion;
        final ImageButton btn_left_tri;

        //버튼과 아이디를 연결
        btn_map = (Button) view.findViewById(R.id.btn_map);
        btn_app_upload = (Button) view.findViewById(R.id.btn_app_upload);
        btn_suggestion = (Button) view.findViewById(R.id.btn_suggestion);
        btn_left_tri = (ImageButton) view.findViewById(R.id.btn_left);

        //메뉴에서 바로 이동시 검은색으로
        Log.i("name2 : " , name2);
        switch (name2){
            case "map" :
                btn_map.setTextColor(Color.BLACK);
                break;
            case "app_upload" :
                btn_app_upload.setTextColor(Color.BLACK);
                break;
            case "suggestion" :
                btn_suggestion.setTextColor(Color.BLACK);
                break;

        }

        //클릭 되었을 때 해당항목은 검정색, 나머지는 회색
        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_map.setTextColor(Color.GRAY);
                btn_app_upload.setTextColor(Color.GRAY);
                btn_suggestion.setTextColor(Color.GRAY);

                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);

                switch (v.getId()){
                    case R.id.btn_map :
                        btn_map.setTextColor(Color.BLACK);
                        //setContentFragment("map");
                        intent_chosen_page.putExtra("name","etc2");
                        intent_chosen_page.putExtra("name2", "map");
                        startActivity(intent_chosen_page);
                        btn_map.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_app_upload :
                        btn_app_upload.setTextColor(Color.BLACK);
                        //setContentFragment("app_upload");
                        intent_chosen_page.putExtra("name","etc2");
                        intent_chosen_page.putExtra("name2", "app_upload");
                        startActivity(intent_chosen_page);
                        btn_app_upload.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_suggestion :
                        btn_suggestion.setTextColor(Color.BLACK);
                        //setContentFragment("suggestion");
                        intent_chosen_page.putExtra("name","etc2");
                        intent_chosen_page.putExtra("name2", "suggestion");
                        startActivity(intent_chosen_page);
                        btn_suggestion.setTextColor(Color.GRAY);
                        break;

                    case R.id.btn_left :
                        intent_chosen_page.putExtra("name","etc");
                        intent_chosen_page.putExtra("name2", "dailybible");
                        startActivity(intent_chosen_page);
                        break;

                }
                switch (name2){
                    case "map" :
                        btn_map.setTextColor(Color.BLACK);
                        break;
                    case "app_upload" :
                        btn_app_upload.setTextColor(Color.BLACK);
                        break;
                    case "suggestion" :
                        btn_suggestion.setTextColor(Color.BLACK);
                        break;

                }

            }
        };

        //클릭 시 반응하게
        btn_map.setOnClickListener(clickListener);
        btn_app_upload.setOnClickListener(clickListener);
        btn_suggestion.setOnClickListener(clickListener);
        btn_left_tri.setOnClickListener(clickListener);

        return view;
    }
    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(content==null) {
            content = "map";
            name2 = "map";
        }

        switch (content){
            case "map":
                //intro 호출
                etc_map etc_map = new etc_map();
                transaction.replace(R.id.content_layout, etc_map);
                transaction.commit();
                break;
            case "app_upload":
                //intro 호출
                etc_app_upload etc_app_upload = new etc_app_upload();
                transaction.replace(R.id.content_layout, etc_app_upload);
                transaction.commit();
                break;
            case "suggestion":
                //intro 호출
                etc_suggestion etc_suggestion = new etc_suggestion();
                transaction.replace(R.id.content_layout, etc_suggestion);
                transaction.commit();
                break;
        }
    }
}
