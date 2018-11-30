package com.kyu.user.nsgprac2.Worship;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.kyu.user.nsgprac2.R;

/**
 * Created by hyk on 2018-02-21.
 */

public class ws_tbm extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/worship/tbm_worship/";
    String txtUrl = "http://220.230.125.167/Nsg_Img/worship/tbm_worship/";

    ImageView img_tbm;
    getImage get_tbm_Image;

    TextView txt_tbm, txt_conti;
    getText get_tbm_Text, get_tbm_conti;

    private Button replay_tbm;

    public ws_tbm(){
        get_tbm_Image = new getImage();
        get_tbm_Text = new getText();
        get_tbm_conti = new getText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ws_tbm, container, false);

        img_tbm = (ImageView) view.findViewById(R.id.img_tbm);
        get_tbm_Image.execute(img_tbm, Url+"tbm.png" );

        txt_tbm = (TextView) view.findViewById(R.id.txt_tbm);
        get_tbm_Text.execute(txt_tbm, txtUrl + "tbm.txt");

        txt_conti = (TextView) view.findViewById(R.id.txt_tbm_conti);
        get_tbm_conti.execute(txt_conti, txtUrl + "conti.txt");

        replay_tbm = (Button) view.findViewById(R.id.btn_replay_tbm);

        ImageButton.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_replay_tbm:
                        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nsgrace.org/main/sub.html?pageCode=175"));
                        startActivity(myIntent);
                        break;
                }
            }
        };

        replay_tbm.setOnClickListener(clickListener);

        return view;
    }

}
