package com.kyu.user.nsgprac2.Worship;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class ws_gpt extends Fragment {

    String Url = "http://220.230.125.167/Nsg_Img/worship/sun_worship/";
    String txtUrl = "http://220.230.125.167/Nsg_Img/worship/sun_worship/";

    ImageView img_sun;
    getImage get_sun_Image;

    TextView txt_sun, txt_conti;
    getText get_sun_Text, get_sun_conti;

    private Button replay_gpt, replay_ws_gpt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        get_sun_Image = new getImage();
        get_sun_Text = new getText();
        get_sun_conti = new getText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ws_gpt, container, false);

        img_sun = (ImageView) view.findViewById(R.id.img_sun);
        get_sun_Image.execute(img_sun, Url+"sun.png" );

        txt_sun = (TextView) view.findViewById(R.id.txt_sun);
        get_sun_Text.execute(txt_sun, txtUrl + "sun.txt");

        txt_conti = (TextView) view.findViewById(R.id.txt_sun_conti);
        get_sun_conti.execute(txt_conti, txtUrl + "conti.txt");

        replay_gpt = (Button) view.findViewById(R.id.btn_replay_gpt);
        replay_ws_gpt = (Button) view.findViewById(R.id.btn_replay_ws_gpt);

        ImageButton.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_replay_gpt:
                        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nsgrace.org/main/sub.html?pageCode=8"));
                        startActivity(myIntent);
                        break;
                    case R.id.btn_replay_ws_gpt:
                        Intent myIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nsgrace.org/main/sub.html?pageCode=19"));
                        startActivity(myIntent2);
                        break;
                }
            }
        };

        replay_gpt.setOnClickListener(clickListener);
        replay_ws_gpt.setOnClickListener(clickListener);


        return view;
    }

}
