package com.kyu.user.nsgprac2.Notice;

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

public class notice2 extends Fragment {

    String name1;
    String name2;

    public notice2(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.notice2, container, false);

        Log.i("notice : ", "notice fragment");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("notice2")){
            Log.i("notice ", "notice page is first");
            setContentFragment(name2);
        }else {
            Log.i("notice ", "name2 is change");
            name2 = "notice_album";
            setContentFragment(name2);
        }
        //버튼 선언
        final Button btn_album, btn_adv_video;
        final ImageButton btn_left_tri;

        //버튼과 아이디를 연결
        btn_album = (Button) view.findViewById(R.id.btn_album);
        btn_adv_video = (Button) view.findViewById(R.id.btn_adv_video);
        btn_left_tri = (ImageButton) view.findViewById(R.id.btn_left);

        //메뉴에서 바로 이동시 검은색으로
        Log.i("name2 : " , name2);
        switch (name2){
            case "notice_album" :
                btn_album.setTextColor(Color.BLACK);
                break;
            case "notice_adv_video" :
                btn_adv_video.setTextColor(Color.BLACK);
                break;

        }

        //클릭 되었을 때 해당항목은 검정색, 나머지는 회색
        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_album.setTextColor(Color.GRAY);
                btn_adv_video.setTextColor(Color.GRAY);

                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);

                switch (v.getId()){
                    case R.id.btn_album :
                        btn_album.setTextColor(Color.BLACK);
                        //setContentFragment("notice_album");
                        intent_chosen_page.putExtra("name","notice2");
                        intent_chosen_page.putExtra("name2", "notice_album");
                        startActivity(intent_chosen_page);
                        btn_album.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_adv_video :
                        btn_adv_video.setTextColor(Color.BLACK);
                        //setContentFragment("notice_adv_video");
                        intent_chosen_page.putExtra("name","notice2");
                        intent_chosen_page.putExtra("name2", "notice_adv_video");
                        startActivity(intent_chosen_page);
                        btn_adv_video.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_left :
                        intent_chosen_page.putExtra("name","notice");
                        intent_chosen_page.putExtra("name2", "notice_main_event");
                        startActivity(intent_chosen_page);
                        break;

                }

                switch (name2){
                    case "notice_album" :
                        btn_album.setTextColor(Color.BLACK);
                        break;
                    case "notice_adv_video" :
                        btn_adv_video.setTextColor(Color.BLACK);
                        break;

                }
            }
        };

        //클릭 시 반응하게
        btn_album.setOnClickListener(clickListener);
        btn_adv_video.setOnClickListener(clickListener);
        btn_left_tri.setOnClickListener(clickListener);

        return view;
    }
    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(content==null) {
            content = "notice_main_event";
            name2 = "notice_main_event";
        }

        switch (content){
            case "notice_album":
                //intro 호출
                notice_album notice_album = new notice_album();
                transaction.replace(R.id.content_layout, notice_album);
                transaction.commit();
                break;
            case "notice_adv_video":
                //intro 호출
                notice_adv_video notice_adv_video = new notice_adv_video();
                transaction.replace(R.id.content_layout, notice_adv_video);
                transaction.commit();
                break;
        }
    }
}
