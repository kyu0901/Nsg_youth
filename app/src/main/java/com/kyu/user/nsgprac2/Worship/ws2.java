package com.kyu.user.nsgprac2.Worship;

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

public class ws2 extends Fragment {

    String name1;
    String name2;

    public ws2(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.ws2, container, false);

        Log.i("fragment : ", "ws");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("ws2")){
            Log.i("name2 is ", "first");
            setContentFragment(name2);
        }else {
            Log.i("name2 ", " is change");
            name2 = "ws_live";
            setContentFragment("ws_live");
        }


        //버튼 선언
        final Button btn_live;
        final ImageButton btn_left_tri;;

        //버튼과 아이디를 연결
        btn_live = (Button) view.findViewById(R.id.btn_live);
        btn_left_tri = (ImageButton) view.findViewById(R.id.btn_left);


        //메뉴에서 바로 이동시 검은색으로
        Log.i("name2 : " , name2);
        switch (name2){
            case "ws_live" :
                btn_live.setTextColor(Color.BLACK);
                break;

        }

        //클릭 되었을 때 해당항목은 검정색, 나머지는 회색
        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_live.setTextColor(Color.GRAY);

                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);
                switch (v.getId()){
                    case R.id.btn_live :
                        btn_live.setTextColor(Color.BLACK);
                        //setContentFragment("ws_live");
                        Log.i("ws : ", "btn_gpt click");
                        intent_chosen_page.putExtra("name","ws2");
                        intent_chosen_page.putExtra("name2", "ws_live");
                        startActivity(intent_chosen_page);
                        btn_live.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_left :
                        intent_chosen_page.putExtra("name","ws");
                        intent_chosen_page.putExtra("name2", "ws_gpt");
                        startActivity(intent_chosen_page);
                        break;
                }

                switch (name2){
                    case "ws_live" :
                        btn_live.setTextColor(Color.BLACK);
                        break;

                }
            }
        };

        //클릭 시 반응하게
        btn_live.setOnClickListener(clickListener);
        btn_left_tri.setOnClickListener(clickListener);


        return view;
    }

    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(content==null) {
            content = "ws_live";
            name2 = "ws_live";
        }

        switch (content){
            case "ws_live":
                //intro 호출
                ws_live ws_live = new ws_live();
                transaction.replace(R.id.content_layout, ws_live);
                transaction.commit();
                break;
        }
    }
}
