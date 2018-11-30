package com.kyu.user.nsgprac2.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-21.
 */

public class intro_team_joseph extends Fragment {


    public intro_team_joseph(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        Log.i("intro_team_joseph", " in onCreatView");
        View view = inflater.inflate(R.layout.intro_team_joseph, container, false);

        return view;
    }
}
