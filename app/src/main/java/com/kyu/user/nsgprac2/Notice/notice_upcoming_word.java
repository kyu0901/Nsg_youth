package com.kyu.user.nsgprac2.Notice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kyu.user.nsgprac2.R;
import com.kyu.user.nsgprac2.Worship.getText;

/**
 * Created by hyk on 2018-02-21.
 */

public class notice_upcoming_word extends Fragment {

    String txtUrl = "http://220.230.125.167/Nsg_Img/worship/";

    TextView txt_gpt, txt_tbm;
    getText get_txt_gpt, get_txt_tbm;

    public notice_upcoming_word(){
        get_txt_gpt = new getText();
        get_txt_tbm = new getText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.notice_upcoming_word, container, false);

        txt_gpt = (TextView) view.findViewById(R.id.notice_upcoming_word_gpt);
        get_txt_gpt.execute(txt_gpt, txtUrl + "sun_worship/sun.txt");

        txt_tbm = (TextView) view.findViewById(R.id.notice_upcoming_word_tbm);
        get_txt_tbm.execute(txt_tbm, txtUrl + "tbm_worship/tbm.txt");

        return view;
    }
}
