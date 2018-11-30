package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyu.user.nsgprac2.R;

public class intro_circle_youth_right_knowledge extends android.support.v4.app.Fragment {


    public intro_circle_youth_right_knowledge(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("intro_circle_youth_r_k", " in onCreatView");
        View view = inflater.inflate(R.layout.intro_circle_youth_right_knowledge, container, false);

        return view;
    }

}
