package com.kyu.user.nsgprac2.Pray;

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

import com.kyu.user.nsgprac2.ChosenPage;
import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-08.
 */

public class pray extends Fragment {

    String name1;
    String name2;

    public pray(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.pray, container, false);

        Log.i("fragment : ", "pray");

        name1 = getActivity().getIntent().getStringExtra("name");
        name2 = getActivity().getIntent().getStringExtra("name2");

        if(name1.equals("pray")){
            Log.i("pray ", "pray page is first");
            setContentFragment(name2);
        }else {
            Log.i("name2 ", " is change");
            name2 = "pray_weekly_pray";
            setContentFragment(name2);
        }

        //버튼 선언
        final Button btn_pray_donation, btn_pray_weekly_pray;

        //버튼과 아이디를 연결
        btn_pray_donation = (Button) view.findViewById(R.id.btn_pray_donation);
        btn_pray_weekly_pray = (Button) view.findViewById(R.id.btn_pray_weekly_pray);

        //메뉴에서 바로 이동시 검은색으로
        Log.i("name2 : " , name2);
        switch (name2){
            case "pray_donation" :
                Log.i("name2 is ", name2);
                btn_pray_donation.setTextColor(Color.BLACK);
                break;
            case "pray_weekly_pray" :
                btn_pray_weekly_pray.setTextColor(Color.BLACK);
                break;

        }

        //클릭 되었을 때 해당항목은 검정색, 나머지는 회색
        Button.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_pray_donation.setTextColor(Color.GRAY);
                btn_pray_weekly_pray.setTextColor(Color.GRAY);
                Intent intent_chosen_page = new Intent(getActivity(), ChosenPage.class);

                switch (v.getId()){
                    case R.id.btn_pray_donation :
                        btn_pray_donation.setTextColor(Color.BLACK);
                        //setContentFragment("pray_donation");
                        Log.i("pray : ", "btn_pray_donation click");
                        intent_chosen_page.putExtra("name","pray");
                        intent_chosen_page.putExtra("name2", "pray_donation");
                        startActivity(intent_chosen_page);
                        btn_pray_donation.setTextColor(Color.GRAY);
                        break;
                    case R.id.btn_pray_weekly_pray :
                        btn_pray_weekly_pray.setTextColor(Color.BLACK);
                        //setContentFragment("pray_weekly_pray");
                        intent_chosen_page.putExtra("name","pray");
                        intent_chosen_page.putExtra("name2", "pray_weekly_pray");
                        startActivity(intent_chosen_page);
                        btn_pray_weekly_pray.setTextColor(Color.GRAY);
                        break;
                }

                switch (name2){
                    case "pray_donation" :
                        Log.i("name2 is ", name2);
                        btn_pray_donation.setTextColor(Color.BLACK);
                        break;
                    case "pray_weekly_pray" :
                        btn_pray_weekly_pray.setTextColor(Color.BLACK);
                        break;

                }
            }
        };

        //클릭 시 반응하게
        btn_pray_donation.setOnClickListener(clickListener);
        btn_pray_weekly_pray.setOnClickListener(clickListener);

        return view;
    }

    private void setContentFragment(String content){
        //프레그먼트 사용을 위해
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(content==null) {
            content = "pray_weekly_pray";
            name2 = "pray_weekly_pray";
        }

        switch (content){
            case "pray_donation":
                //intro 호출
                pray_donation pray_donation = new pray_donation();
                transaction.replace(R.id.content_layout, pray_donation);
                transaction.commit();
                break;
            case "pray_weekly_pray":
                //intro 호출
                pray_weekly_pray pray_weekly_pray = new pray_weekly_pray();
                transaction.replace(R.id.content_layout, pray_weekly_pray);
                transaction.commit();
                break;
        }
    }
}
