package com.kyu.user.nsgprac2.Notice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-21.
 */

public class notice_main_event extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/notice/main_event/";

    ImageButton img_event_1, img_event_2, img_event_3, img_event_4, img_event_5, img_event_6, img_event_7, img_event_8,
            img_event_9, img_event_10;
    getImage get_event_Image1, get_event_Image2, get_event_Image3, get_event_Image4, get_event_Image5, get_event_Image6,
            get_event_Image7, get_event_Image8, get_event_Image9, get_event_Image10;

    getNum get_Num;

    TextView txt_event_1, txt_event_2, txt_event_3, txt_event_4, txt_event_5,
            txt_event_6, txt_event_7, txt_event_8, txt_event_9, txt_event_10;

    getText get_txt_event_1, get_txt_event_2, get_txt_event_3, get_txt_event_4, get_txt_event_5,
            get_txt_event_6, get_txt_event_7, get_txt_event_8, get_txt_event_9, get_txt_event_10;

    public notice_main_event() {

        get_event_Image1 = new getImage();
        get_event_Image2 = new getImage();
        get_event_Image3 = new getImage();
        get_event_Image4 = new getImage();
        get_event_Image5 = new getImage();
        get_event_Image6 = new getImage();
        get_event_Image7 = new getImage();
        get_event_Image8 = new getImage();
        get_event_Image9 = new getImage();
        get_event_Image10 = new getImage();

        get_Num = new getNum();

        get_txt_event_1 = new getText();
        get_txt_event_2 = new getText();
        get_txt_event_3 = new getText();
        get_txt_event_4 = new getText();
        get_txt_event_5 = new getText();
        get_txt_event_6 = new getText();
        get_txt_event_7 = new getText();
        get_txt_event_8 = new getText();
        get_txt_event_9 = new getText();
        get_txt_event_10 = new getText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.notice_main_event, container, false);

        String zx = "";
        try {
            zx = get_Num.execute(zx, Url + "sample.txt").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //없는 layout을 지우기 위함
        Integer[] numBtnIDs = {R.id.l1, R.id.l2, R.id.l3, R.id.l4, R.id.l5, R.id.l6,
                R.id.l7, R.id.l8, R.id.l9, R.id.l10};
        LinearLayout linear[] = new LinearLayout[10];

        for (int i = 0; i < 10; i++) {
            linear[i] = (LinearLayout) view.findViewById(numBtnIDs[i]);
        }



        img_event_1 = (ImageButton) view.findViewById(R.id.img_event_1);
        get_event_Image1.execute(img_event_1, Url + "img_event_1.jpeg");

        txt_event_1 = (TextView) view.findViewById(R.id.txt_event_1);
        get_txt_event_1.execute(txt_event_1, Url + "txt_event_1.txt");

        img_event_2 = (ImageButton) view.findViewById(R.id.img_event_2);
        get_event_Image2.execute(img_event_2, Url + "img_event_2.jpeg");

        txt_event_2 = (TextView) view.findViewById(R.id.txt_event_2);
        get_txt_event_2.execute(txt_event_2, Url + "txt_event_2.txt");

        img_event_3 = (ImageButton) view.findViewById(R.id.img_event_3);
        get_event_Image3.execute(img_event_3, Url + "img_event_3.jpeg");

        txt_event_3 = (TextView) view.findViewById(R.id.txt_event_3);
        get_txt_event_3.execute(txt_event_3, Url + "txt_event_3.txt");

        img_event_4 = (ImageButton) view.findViewById(R.id.img_event_4);
        get_event_Image4.execute(img_event_4, Url + "img_event_4.jpeg");

        txt_event_4 = (TextView) view.findViewById(R.id.txt_event_4);
        get_txt_event_4.execute(txt_event_4, Url + "txt_event_4.txt");

        img_event_5 = (ImageButton) view.findViewById(R.id.img_event_5);
        get_event_Image5.execute(img_event_5, Url + "img_event_5.jpeg");

        txt_event_5 = (TextView) view.findViewById(R.id.txt_event_5);
        get_txt_event_5.execute(txt_event_5, Url + "txt_event_5.txt");

        img_event_6 = (ImageButton) view.findViewById(R.id.img_event_6);
        get_event_Image6.execute(img_event_6, Url + "img_event_6.jpeg");

        txt_event_6 = (TextView) view.findViewById(R.id.txt_event_6);
        get_txt_event_6.execute(txt_event_6, Url + "txt_event_6.txt");

        img_event_7 = (ImageButton) view.findViewById(R.id.img_event_7);
        get_event_Image7.execute(img_event_7, Url + "img_event_7.jpeg");

        txt_event_7 = (TextView) view.findViewById(R.id.txt_event_7);
        get_txt_event_7.execute(txt_event_7, Url + "txt_event_7.txt");

        img_event_8 = (ImageButton) view.findViewById(R.id.img_event_8);
        get_event_Image8.execute(img_event_8, Url + "img_event_8.jpeg");

        txt_event_8 = (TextView) view.findViewById(R.id.txt_event_8);
        get_txt_event_8.execute(txt_event_8, Url + "txt_event_8.txt");

        img_event_9 = (ImageButton) view.findViewById(R.id.img_event_9);
        get_event_Image9.execute(img_event_9, Url + "img_event_9.jpeg");

        txt_event_9 = (TextView) view.findViewById(R.id.txt_event_9);
        get_txt_event_9.execute(txt_event_9, Url + "txt_event_9.txt");

        img_event_10 = (ImageButton) view.findViewById(R.id.img_event_10);
        get_event_Image10.execute(img_event_10, Url + "img_event_10.jpeg");

        txt_event_10 = (TextView) view.findViewById(R.id.txt_event_10);
        get_txt_event_10.execute(txt_event_10, Url + "txt_event_10.txt");

        ImageButton.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.img_event_1:
                        setContentFragment("1");
                        break;

                    case R.id.img_event_2:
                        setContentFragment("2");
                        break;

                    case R.id.img_event_3:
                        setContentFragment("3");
                        break;

                    case R.id.img_event_4:
                        setContentFragment("4");
                        break;

                    case R.id.img_event_5:
                        setContentFragment("5");
                        break;

                    case R.id.img_event_6:
                        setContentFragment("1");
                        break;

                    case R.id.img_event_7:
                        setContentFragment("7");
                        break;

                    case R.id.img_event_8:
                        setContentFragment("8");
                        break;

                    case R.id.img_event_9:
                        setContentFragment("9");
                        break;

                    case R.id.img_event_10:
                        setContentFragment("10");
                        break;

                }
            }
        };

        img_event_1.setOnClickListener(clickListener);
        img_event_2.setOnClickListener(clickListener);
        img_event_3.setOnClickListener(clickListener);
        img_event_4.setOnClickListener(clickListener);
        img_event_5.setOnClickListener(clickListener);
        img_event_6.setOnClickListener(clickListener);
        img_event_7.setOnClickListener(clickListener);
        img_event_8.setOnClickListener(clickListener);
        img_event_9.setOnClickListener(clickListener);
        img_event_10.setOnClickListener(clickListener);

        int len = zx.length();
        for (int i = len - 1; i <= 9; i++) {
            linear[i].removeAllViews();
        }

        return view;
    }

    private void setContentFragment(String content) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        RelativeLayout rv = (RelativeLayout) getActivity().findViewById(R.id.notice_main_event_main);
        rv.removeAllViews();

        switch (content) {
            case "1":
                notice_main_event_1 notice_main_event_1 = new notice_main_event_1();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_1);
                transaction.commit();
                break;

            case "2":
                notice_main_event_2 notice_main_event_2 = new notice_main_event_2();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_2);
                transaction.commit();
                break;

            case "3":
                notice_main_event_3 notice_main_event_3 = new notice_main_event_3();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_3);
                transaction.commit();
                break;

            case "4":
                notice_main_event_4 notice_main_event_4 = new notice_main_event_4();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_4);
                transaction.commit();
                break;

            case "5":
                notice_main_event_5 notice_main_event_5 = new notice_main_event_5();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_5);
                transaction.commit();
                break;
            case "6":
                notice_main_event_6 notice_main_event_6 = new notice_main_event_6();
                transaction.replace(R.id.pray_donation_main, notice_main_event_6);
                transaction.commit();
                break;

            case "7":
                notice_main_event_7 notice_main_event_7 = new notice_main_event_7();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_7);
                transaction.commit();
                break;

            case "8":
                notice_main_event_8 notice_main_event_8 = new notice_main_event_8();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_8);
                transaction.commit();
                break;

            case "9":
                notice_main_event_9 notice_main_event_9 = new notice_main_event_9();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_9);
                transaction.commit();
                break;

            case "10":
                notice_main_event_10 notice_main_event_10 = new notice_main_event_10();
                transaction.replace(R.id.notice_main_event_main, notice_main_event_10);
                transaction.commit();
                break;
        }
    }
}
