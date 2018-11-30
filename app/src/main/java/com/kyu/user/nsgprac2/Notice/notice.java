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

public class notice extends Fragment {

    String name1;
    String name2;

    public notice(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.notice, container, false);

        Log.i("notice : ", "notice fragment");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("notice")){
            Log.i("notice ", "notice page is first");
            setContentFragment(name2);
        }else {
            Log.i("notice ", "name2 is change");
            name2 = "notice_main_event";
            setContentFragment(name2);
        }
        //버튼 선언
        final Button btn_main_event, btn_weekly_news, btn_upcoming_word, btn_survey;
        final ImageButton btn_right_tri;

        //버튼과 아이디를 연결
        btn_main_event = (Button) view.findViewById(R.id.btn_main_event);
        btn_weekly_news = (Button) view.findViewById(R.id.btn_weekly_news);
        btn_upcoming_word = (Button) view.findViewById(R.id.btn_upcoming_word);
        btn_survey = (Button) view.findViewById(R.id.btn_survey);
        btn_right_tri = (ImageButton) view.findViewById(R.id.btn_right);

        //메뉴에서 바로 이동시 검은색으로
        Log.i("name2 : " , name2);
        switch (name2){
            case "notice_main_event" :
                Log.i("name2 is ", name2);
                btn_main_event.setTextColor(Color.BLACK);
                break;
            case "notice_weekly_news" :
                btn_weekly_news.setTextColor(Color.BLACK);
                break;
            case "notice_upcoming_word" :
                btn_upcoming_word.setTextColor(Color.BLACK);
                break;
            case "notice_survey" :
                btn_survey.setTextColor(Color.BLACK);
                break;

        }

        //클릭 되었을 때 해당항목은 검정색, 나머지는 회색
        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_main_event.setTextColor(Color.GRAY);
                btn_weekly_news.setTextColor(Color.GRAY);
                btn_upcoming_word.setTextColor(Color.GRAY);
                btn_survey.setTextColor(Color.GRAY);

                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);

                switch (v.getId()){
                    case R.id.btn_main_event :
                        btn_main_event.setTextColor(Color.BLACK);
                        //setContentFragment("notice_main_event");
                        Log.i("notice : ", "btn_main_event click");
                        intent_chosen_page.putExtra("name","notice");
                        intent_chosen_page.putExtra("name2", "notice_main_event");
                        startActivity(intent_chosen_page);
                        btn_main_event.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_weekly_news :
                        btn_weekly_news.setTextColor(Color.BLACK);
                        //setContentFragment("notice_weekly_news");
                        intent_chosen_page.putExtra("name","notice");
                        intent_chosen_page.putExtra("name2", "notice_weekly_news");
                        startActivity(intent_chosen_page);
                        btn_weekly_news.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_upcoming_word :
                        btn_upcoming_word.setTextColor(Color.BLACK);
                        //setContentFragment("notice_upcoming_word");
                        intent_chosen_page.putExtra("name","notice");
                        intent_chosen_page.putExtra("name2", "notice_upcoming_word");
                        startActivity(intent_chosen_page);
                        btn_upcoming_word.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_survey :
                        btn_survey.setTextColor(Color.BLACK);
                        //setContentFragment("notice_survey");
                        intent_chosen_page.putExtra("name","notice");
                        intent_chosen_page.putExtra("name2", "notice_survey");
                        startActivity(intent_chosen_page);
                        btn_survey.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_right :
                        intent_chosen_page.putExtra("name","notice2");
                        intent_chosen_page.putExtra("name2", "notice_album");
                        startActivity(intent_chosen_page);
                        break;
                }

                switch (name2){
                    case "notice_main_event" :
                        Log.i("name2 is ", name2);
                        btn_main_event.setTextColor(Color.BLACK);
                        break;
                    case "notice_weekly_news" :
                        btn_weekly_news.setTextColor(Color.BLACK);
                        break;
                    case "notice_upcoming_word" :
                        btn_upcoming_word.setTextColor(Color.BLACK);
                        break;
                    case "notice_survey" :
                        btn_survey.setTextColor(Color.BLACK);
                        break;

                }
            }
        };

        //클릭 시 반응하게
        btn_main_event.setOnClickListener(clickListener);
        btn_weekly_news.setOnClickListener(clickListener);
        btn_upcoming_word.setOnClickListener(clickListener);
        btn_survey.setOnClickListener(clickListener);
        btn_right_tri.setOnClickListener(clickListener);

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
            case "notice_main_event":
                //intro 호출
                notice_main_event notice_main_event = new notice_main_event();
                transaction.replace(R.id.content_layout, notice_main_event);
                transaction.commit();
                break;
            case "notice_weekly_news":
                //intro 호출
                notice_weekly_news notice_weekly_news = new notice_weekly_news();
                transaction.replace(R.id.content_layout, notice_weekly_news);
                transaction.commit();
                break;
            case "notice_upcoming_word":
                //intro 호출
                notice_upcoming_word notice_upcoming_word = new notice_upcoming_word();
                transaction.replace(R.id.content_layout, notice_upcoming_word);
                transaction.commit();
                break;
            case "notice_survey":
                //intro 호출
                notice_survey notice_survey = new notice_survey();
                transaction.replace(R.id.content_layout, notice_survey);
                transaction.commit();
                break;
        }
    }
}
