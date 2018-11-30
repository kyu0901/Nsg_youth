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

public class etc extends Fragment {

    String name1;
    String name2;

    public etc(){



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.etc, container, false);

        Log.i("fragment : ", "etc");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("etc")){
            Log.i("etc ", "etc page is first");
            setContentFragment(name2);
        }else {
            Log.i("etc ", "name2 is change");
            name2 = "dailybible";
            setContentFragment("dailybible");
        }

        //버튼 선언
        final Button btn_dailybible, btn_adv_request, btn_place_reg, btn_car_reg;
        final ImageButton btn_right_tri;

        //버튼과 아이디를 연결
        btn_dailybible = (Button) view.findViewById(R.id.btn_dailybible);
        btn_adv_request = (Button) view.findViewById(R.id.btn_adv_request);
        btn_place_reg = (Button) view.findViewById(R.id.btn_place_reg);
        btn_car_reg = (Button) view.findViewById(R.id.btn_car_reg);
        btn_right_tri = (ImageButton) view.findViewById(R.id.btn_right);

        //메뉴에서 바로 이동시 검은색으로
        Log.i("name2 : " , name2);
        switch (name2){
            case "dailybible" :
                Log.i("name2 is ", name2);
                btn_dailybible.setTextColor(Color.BLACK);
                break;

            case "adv_request" :
                btn_adv_request.setTextColor(Color.BLACK);
                break;

            case "place_reg" :
                btn_place_reg.setTextColor(Color.BLACK);
                break;

            case "car_reg" :
                btn_car_reg.setTextColor(Color.BLACK);
                break;
        }

        //클릭 되었을 때 해당항목은 검정색, 나머지는 회색
        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_dailybible.setTextColor(Color.GRAY);
                btn_adv_request.setTextColor(Color.GRAY);
                btn_place_reg.setTextColor(Color.GRAY);
                btn_car_reg.setTextColor(Color.GRAY);

                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);
                switch (v.getId()){
                    case R.id.btn_dailybible :
                        btn_dailybible.setTextColor(Color.BLACK);
                        //setContentFragment("dailybible");
                        Log.i("etc : ", "btn_dailybible click");
                        intent_chosen_page.putExtra("name","etc");
                        intent_chosen_page.putExtra("name2", "dailybible");
                        startActivity(intent_chosen_page);
                        btn_dailybible.setTextColor(Color.GRAY);
                        break;

                    case R.id.btn_adv_request :
                        btn_adv_request.setTextColor(Color.BLACK);
                        //setContentFragment("adv_request");
                        intent_chosen_page.putExtra("name","etc");
                        intent_chosen_page.putExtra("name2", "adv_request");
                        startActivity(intent_chosen_page);
                        btn_adv_request.setTextColor(Color.GRAY);
                        break;

                    case R.id.btn_place_reg :
                        btn_place_reg.setTextColor(Color.BLACK);
                        //setContentFragment("place_reg");
                        intent_chosen_page.putExtra("name","etc");
                        intent_chosen_page.putExtra("name2", "place_reg");
                        startActivity(intent_chosen_page);
                        btn_place_reg.setTextColor(Color.GRAY);
                        break;

                    case R.id.btn_car_reg :
                        btn_car_reg.setTextColor(Color.BLACK);
                        //setContentFragment("car_reg");
                        intent_chosen_page.putExtra("name","etc");
                        intent_chosen_page.putExtra("name2", "car_reg");
                        startActivity(intent_chosen_page);
                        btn_car_reg.setTextColor(Color.GRAY);
                        break;

                    case R.id.btn_right :
                        intent_chosen_page.putExtra("name","etc2");
                        intent_chosen_page.putExtra("name2", "map");
                        startActivity(intent_chosen_page);
                        break;

                }

                switch (name2){
                    case "dailybible" :
                        Log.i("name2 is ", name2);
                        btn_dailybible.setTextColor(Color.BLACK);
                        break;

                    case "adv_request" :
                        btn_adv_request.setTextColor(Color.BLACK);
                        break;

                    case "place_reg" :
                        btn_place_reg.setTextColor(Color.BLACK);
                        break;

                    case "car_reg" :
                        btn_car_reg.setTextColor(Color.BLACK);
                        break;
                }
            }
        };

        //클릭 시 반응하게
        btn_adv_request.setOnClickListener(clickListener);
        btn_dailybible.setOnClickListener(clickListener);
        btn_place_reg.setOnClickListener(clickListener);
        btn_car_reg.setOnClickListener(clickListener);
        btn_right_tri.setOnClickListener(clickListener);

        return view;
    }
    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(content==null) {
            content = "dailybible";
            name2 = "dailybible";
        }

        switch (content){
            case "dailybible":
                //intro 호출
                etc_dailybible etc_dailybible = new etc_dailybible();
                transaction.replace(R.id.content_layout, etc_dailybible);
                transaction.commit();
                break;

            case "adv_request":
                //intro 호출
                etc_adv_request etc_adv_request = new etc_adv_request();
                transaction.replace(R.id.content_layout, etc_adv_request);
                transaction.commit();
                break;

            case "place_reg":
                etc_place_reg etc_place_reg = new etc_place_reg();
                transaction.replace(R.id.content_layout, etc_place_reg);
                transaction.commit();
                break;

            case "car_reg":
                etc_car_reg etc_car_reg = new etc_car_reg();
                transaction.replace(R.id.content_layout, etc_car_reg);
                transaction.commit();
                break;

        }
    }
}
