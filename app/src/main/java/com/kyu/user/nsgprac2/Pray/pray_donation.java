package com.kyu.user.nsgprac2.Pray;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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

public class pray_donation extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/pray/support_pray/";

    ImageButton img_donation_1, img_donation_2, img_donation_3, img_donation_4, img_donation_5, img_donation_6, img_donation_7, img_donation_8,
            img_donation_9, img_donation_10;

    getImage get_donation_Image1, get_donation_Image2, get_donation_Image3, get_donation_Image4, get_donation_Image5, get_donation_Image6,
            get_donation_Image7, get_donation_Image8, get_donation_Image9, get_donation_Image10;

    TextView txt_donation_1, txt_donation_2, txt_donation_3, txt_donation_4, txt_donation_5,
            txt_donation_6, txt_donation_7, txt_donation_8, txt_donation_9, txt_donation_10;

    getText get_txt_donation_1, get_txt_donation_2, get_txt_donation_3, get_txt_donation_4, get_txt_donation_5,
            get_txt_donation_6, get_txt_donation_7, get_txt_donation_8, get_txt_donation_9, get_txt_donation_10;


    getNum get_Num;

    public pray_donation() {

        get_donation_Image1 = new getImage();
        get_donation_Image2 = new getImage();
        get_donation_Image3 = new getImage();
        get_donation_Image4 = new getImage();
        get_donation_Image5 = new getImage();
        get_donation_Image6 = new getImage();
        get_donation_Image7 = new getImage();
        get_donation_Image8 = new getImage();
        get_donation_Image9 = new getImage();
        get_donation_Image10 = new getImage();

        get_txt_donation_1 = new getText();
        get_txt_donation_2 = new getText();
        get_txt_donation_3 = new getText();
        get_txt_donation_4 = new getText();
        get_txt_donation_5 = new getText();
        get_txt_donation_6 = new getText();
        get_txt_donation_7 = new getText();
        get_txt_donation_8 = new getText();
        get_txt_donation_9 = new getText();
        get_txt_donation_10 = new getText();

        get_Num = new getNum();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pray_donation, container, false);


        //sample.txt의 길이를 가지고 몇 개의 기도편지가 있는 지를 알 수 있다.
        String zx = "";
        try {
            zx = get_Num.execute(zx, Url + "sample.txt").get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("msg1 : ", zx);

        System.out.println(zx.length());
        // k = Integer.parseInt(txt_donation_1.getText().toString());


        img_donation_1 = (ImageButton) view.findViewById(R.id.img_pray_donation_1);
        get_donation_Image1.execute(img_donation_1, Url + "pray_donation_1.jpeg");

        txt_donation_1 = (TextView) view.findViewById(R.id.txt_pray_donation_1);
        get_txt_donation_1.execute(txt_donation_1, Url + "pray_donation_1.txt");

        img_donation_2 = (ImageButton) view.findViewById(R.id.img_pray_donation_2);
        get_donation_Image2.execute(img_donation_2, Url + "pray_donation_2.jpeg");

        txt_donation_2 = (TextView) view.findViewById(R.id.txt_pray_donation_2);
        get_txt_donation_2.execute(txt_donation_2, Url + "pray_donation_2.txt");

        img_donation_3 = (ImageButton) view.findViewById(R.id.img_pray_donation_3);
        get_donation_Image3.execute(img_donation_3, Url + "pray_donation_3.jpeg");

        txt_donation_3 = (TextView) view.findViewById(R.id.txt_pray_donation_3);
        get_txt_donation_3.execute(txt_donation_3, Url + "pray_donation_3.txt");

        img_donation_4 = (ImageButton) view.findViewById(R.id.img_pray_donation_4);
        get_donation_Image4.execute(img_donation_4, Url + "pray_donation_4.jpeg");

        txt_donation_4 = (TextView) view.findViewById(R.id.txt_pray_donation_4);
        get_txt_donation_4.execute(txt_donation_4, Url + "pray_donation_4.txt");

        img_donation_5 = (ImageButton) view.findViewById(R.id.img_pray_donation_5);
        get_donation_Image5.execute(img_donation_5, Url + "pray_donation_5.jpeg");

        txt_donation_5 = (TextView) view.findViewById(R.id.txt_pray_donation_5);
        get_txt_donation_5.execute(txt_donation_5, Url + "pray_donation_5.txt");

        img_donation_6 = (ImageButton) view.findViewById(R.id.img_pray_donation_6);
        get_donation_Image6.execute(img_donation_6, Url + "pray_donation_6.jpeg");

        txt_donation_6 = (TextView) view.findViewById(R.id.txt_pray_donation_6);
        get_txt_donation_6.execute(txt_donation_6, Url + "pray_donation_6.txt");

        img_donation_7 = (ImageButton) view.findViewById(R.id.img_pray_donation_7);
        get_donation_Image7.execute(img_donation_7, Url + "pray_donation_7.jpeg");

        txt_donation_7 = (TextView) view.findViewById(R.id.txt_pray_donation_7);
        get_txt_donation_7.execute(txt_donation_7, Url + "pray_donation_7.txt");

        img_donation_8 = (ImageButton) view.findViewById(R.id.img_pray_donation_8);
        get_donation_Image8.execute(img_donation_8, Url + "pray_donation_8.jpeg");

        txt_donation_8 = (TextView) view.findViewById(R.id.txt_pray_donation_8);
        get_txt_donation_8.execute(txt_donation_8, Url + "pray_donation_8.txt");

        img_donation_9 = (ImageButton) view.findViewById(R.id.img_pray_donation_9);
        get_donation_Image9.execute(img_donation_9, Url + "pray_donation_9.jpeg");

        txt_donation_9 = (TextView) view.findViewById(R.id.txt_pray_donation_9);
        get_txt_donation_9.execute(txt_donation_9, Url + "pray_donation_9.txt");

        img_donation_10 = (ImageButton) view.findViewById(R.id.img_pray_donation_10);
        get_donation_Image10.execute(img_donation_10, Url + "pray_donation_10.jpeg");

        txt_donation_10 = (TextView) view.findViewById(R.id.txt_pray_donation_10);
        get_txt_donation_10.execute(txt_donation_10, Url + "pray_donation_10.txt");

        //없는 layout을 지우기 위함
        Integer[] numBtnIDs = {R.id.l1, R.id.l2, R.id.l3, R.id.l4, R.id.l5, R.id.l6,
                R.id.l7, R.id.l8, R.id.l9, R.id.l10};
        LinearLayout linear[] = new LinearLayout[10];

        for(int i=0; i<10; i++){
            linear[i] = (LinearLayout) view.findViewById(numBtnIDs[i]);
        }


        ImageButton.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.img_pray_donation_1:
                        setContentFragment("1");
                        break;

                    case R.id.img_pray_donation_2:
                        setContentFragment("2");
                        break;

                    case R.id.img_pray_donation_3:
                        setContentFragment("3");
                        break;

                    case R.id.img_pray_donation_4:
                        setContentFragment("4");
                        break;

                    case R.id.img_pray_donation_5:
                        setContentFragment("5");
                        break;

                    case R.id.img_pray_donation_6:
                        setContentFragment("6");
                        break;

                    case R.id.img_pray_donation_7:
                        setContentFragment("7");
                        break;

                    case R.id.img_pray_donation_8:
                        setContentFragment("8");
                        break;

                    case R.id.img_pray_donation_9:
                        setContentFragment("9");
                        break;

                    case R.id.img_pray_donation_10:
                        setContentFragment("10");
                        break;


                }
            }
        };

        img_donation_1.setOnClickListener(clickListener);
        img_donation_2.setOnClickListener(clickListener);
        img_donation_3.setOnClickListener(clickListener);
        img_donation_4.setOnClickListener(clickListener);
        img_donation_5.setOnClickListener(clickListener);
        img_donation_6.setOnClickListener(clickListener);
        img_donation_7.setOnClickListener(clickListener);
        img_donation_8.setOnClickListener(clickListener);
        img_donation_9.setOnClickListener(clickListener);
        img_donation_10.setOnClickListener(clickListener);

        int len = zx.length();
        for (int i = len - 1; i <= 9; i++) {
            linear[i].removeAllViews();
        }

        return view;
    }

    private void setContentFragment(String content) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        RelativeLayout rv = (RelativeLayout) getActivity().findViewById(R.id.pray_donation_main);
        rv.removeAllViews();

        switch (content) {
            case "1":
                pray_donation_1 pray_donation_1 = new pray_donation_1();
                transaction.replace(R.id.pray_donation_main, pray_donation_1);
                transaction.commit();
                break;

            case "2":
                pray_donation_2 pray_donation_2 = new pray_donation_2();
                transaction.replace(R.id.pray_donation_main, pray_donation_2);
                transaction.commit();
                break;

            case "3":
                pray_donation_3 pray_donation_3 = new pray_donation_3();
                transaction.replace(R.id.pray_donation_main, pray_donation_3);
                transaction.commit();
                break;

            case "4":
                pray_donation_4 pray_donation_4 = new pray_donation_4();
                transaction.replace(R.id.pray_donation_main, pray_donation_4);
                transaction.commit();
                break;

            case "5":
                pray_donation_5 pray_donation_5 = new pray_donation_5();
                transaction.replace(R.id.pray_donation_main, pray_donation_5);
                transaction.commit();
                break;
            case "6":
                pray_donation_6 pray_donation_6 = new pray_donation_6();
                transaction.replace(R.id.pray_donation_main, pray_donation_6);
                transaction.commit();
                break;

            case "7":
                pray_donation_7 pray_donation_7 = new pray_donation_7();
                transaction.replace(R.id.pray_donation_main, pray_donation_7);
                transaction.commit();
                break;

            case "8":
                pray_donation_8 pray_donation_8 = new pray_donation_8();
                transaction.replace(R.id.pray_donation_main, pray_donation_8);
                transaction.commit();
                break;

            case "9":
                pray_donation_9 pray_donation_9 = new pray_donation_9();
                transaction.replace(R.id.pray_donation_main, pray_donation_9);
                transaction.commit();
                break;

            case "10":
                pray_donation_10 pray_donation_10 = new pray_donation_10();
                transaction.replace(R.id.pray_donation_main, pray_donation_10);
                transaction.commit();
                break;
        }


    }
}
