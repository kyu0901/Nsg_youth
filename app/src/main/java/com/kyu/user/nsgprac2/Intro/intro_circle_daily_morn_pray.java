package com.kyu.user.nsgprac2.Intro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyu.user.nsgprac2.R;

public class intro_circle_daily_morn_pray extends Fragment {

    public intro_circle_daily_morn_pray(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("intro_circle_daily_m_p", " in onCreatView");
        View view = inflater.inflate(R.layout.intro_circle_daily_morn_pray, container, false);

        return view;
    }
}
