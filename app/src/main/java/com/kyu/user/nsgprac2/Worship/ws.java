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

public class ws extends Fragment {

    String name1;
    String name2;

    public ws(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.ws, container, false);

        Log.i("fragment : ", "ws");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("ws")){
            Log.i("name2 is ", "first");
            setContentFragment(name2);
        }else {
            Log.i("name2 ", " is change");
            name2 = "ws_gpt";
            setContentFragment("ws_gpt");
        }


        //버튼 선언
        final Button btn_gpt, btn_tbm, btn_sat_morn, btn_joseph;
        final ImageButton btn_right_tri;

        //버튼과 아이디를 연결
        btn_gpt = (Button) view.findViewById(R.id.btn_gpt);
        btn_tbm = (Button) view.findViewById(R.id.btn_tbm);
        btn_sat_morn = (Button) view.findViewById(R.id.btn_sat_morn);
        btn_joseph = (Button) view.findViewById(R.id.btn_joseph);
        btn_right_tri = (ImageButton) view.findViewById(R.id.btn_right);


        //메뉴에서 바로 이동시 검은색으로
        Log.i("name2 : " , name2);
        switch (name2){
            case "ws_gpt" :
                Log.i("name2 is ", name2);
                btn_gpt.setTextColor(Color.BLACK);
                break;
            case "ws_tbm" :
                btn_tbm.setTextColor(Color.BLACK);
                break;
            case "ws_sat_morn" :
                btn_sat_morn.setTextColor(Color.BLACK);
                break;
            case "ws_joseph" :
                btn_joseph.setTextColor(Color.BLACK);
                break;

        }

        //클릭 되었을 때 해당항목은 검정색, 나머지는 회색
        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_gpt.setTextColor(Color.GRAY);
                btn_tbm.setTextColor(Color.GRAY);
                btn_sat_morn.setTextColor(Color.GRAY);
                btn_joseph.setTextColor(Color.GRAY);


                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);

                switch (v.getId()){
                    case R.id.btn_gpt :
                        btn_gpt.setTextColor(Color.BLACK);
                        //setContentFragment("ws_gpt");
                        Log.i("ws : ", "btn_gpt click");
                        intent_chosen_page.putExtra("name","ws");
                        intent_chosen_page.putExtra("name2", "ws_gpt");
                        startActivity(intent_chosen_page);
                        btn_gpt.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_tbm :
                        btn_tbm.setTextColor(Color.BLACK);
                        //setContentFragment("ws_tbm");
                        Log.i("ws : ", "btn_tbm click");
                        intent_chosen_page.putExtra("name","ws");
                        intent_chosen_page.putExtra("name2", "ws_tbm");
                        startActivity(intent_chosen_page);
                        btn_tbm.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_sat_morn :
                        btn_sat_morn.setTextColor(Color.BLACK);
                        //setContentFragment("ws_sat_morn");
                        Log.i("ws : ", "btn_sat_morn click");
                        intent_chosen_page.putExtra("name","ws");
                        intent_chosen_page.putExtra("name2", "ws_sat_morn");
                        startActivity(intent_chosen_page);
                        btn_sat_morn.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_joseph :
                        btn_joseph.setTextColor(Color.BLACK);
                        //setContentFragment("ws_joseph");
                        Log.i("ws : ", "btn_joseph click");
                        intent_chosen_page.putExtra("name","ws");
                        intent_chosen_page.putExtra("name2", "ws_joseph");
                        startActivity(intent_chosen_page);
                        btn_joseph.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_right :
                        intent_chosen_page.putExtra("name","ws2");
                        intent_chosen_page.putExtra("name2", "ws_live");
                        startActivity(intent_chosen_page);
                        break;

                }

                switch (name2){
                    case "ws_gpt" :
                        Log.i("name2 is ", name2);
                        btn_gpt.setTextColor(Color.BLACK);
                        break;
                    case "ws_tbm" :
                        btn_tbm.setTextColor(Color.BLACK);
                        break;
                    case "ws_sat_morn" :
                        btn_sat_morn.setTextColor(Color.BLACK);
                        break;
                    case "ws_joseph" :
                        btn_joseph.setTextColor(Color.BLACK);
                        break;

                }
            }
        };

        //클릭 시 반응하게
        btn_gpt.setOnClickListener(clickListener);
        btn_tbm.setOnClickListener(clickListener);
        btn_sat_morn.setOnClickListener(clickListener);
        btn_joseph.setOnClickListener(clickListener);
        btn_right_tri.setOnClickListener(clickListener);


        return view;
    }

    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(content==null) {
            content = "ws_gpt";
            name2 = "ws_gpt";
        }

        switch (content){
            case "ws_gpt":
                //intro 호출
                ws_gpt ws_gpt = new ws_gpt();
                transaction.replace(R.id.content_layout, ws_gpt);
                transaction.commit();
                break;
            case "ws_tbm":
                //intro 호출
                ws_tbm ws_tbm = new ws_tbm();
                transaction.replace(R.id.content_layout, ws_tbm);
                transaction.commit();
                break;
            case "ws_sat_morn":
                //intro 호출
                ws_sat_morn ws_sat_morn = new ws_sat_morn();
                transaction.replace(R.id.content_layout, ws_sat_morn);
                transaction.commit();
                break;
            case "ws_joseph":
                //intro 호출
                ws_joseph ws_joseph = new ws_joseph();
                transaction.replace(R.id.content_layout, ws_joseph);
                transaction.commit();
                break;
        }
    }


}
