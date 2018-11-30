package com.kyu.user.nsgprac2.Pray;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-21.
 */

public class pray_weekly_pray extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/pray/weekly_pray/";

    TextView txt_weekly, txt_weekly2;
    getText get_weekly, get_weekly2;

    public pray_weekly_pray(){


        get_weekly = new getText();
        get_weekly2 = new getText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pray_weekly_pray, container, false);

        txt_weekly = view.findViewById(R.id.txt_pray_weekly_pray);
        get_weekly.execute(txt_weekly, Url + "weekly.txt");

        txt_weekly2 = view.findViewById(R.id.txt_pray_weekly_pray2);
        get_weekly2.execute(txt_weekly2, Url + "weekly2.txt");

        return view;
    }
}
