package com.kyu.user.nsgprac2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String txt_gpt_Url = "http://220.230.125.167/Nsg_Img/worship/sun_worship/sun.txt";
    String txt_tbm_Url = "http://220.230.125.167/Nsg_Img/worship/tbm_worship/tbm.txt";

    TextView txt_sun, txt_tbm;
    getText_Home get_sun_Text, get_tbm_Text;

    //우측 메뉴 클릭 후 들어간 이후인지 아닌지
    private boolean move;


    // slide menu
    private DisplayMetrics metrics;
    private LinearLayout rr_mainLayout;
    private LinearLayout rr_menuLayout;
    private FrameLayout.LayoutParams rightMenuLayoutPrams;

    private int rightMenuWidth;
    private static boolean isRightExpanded;

    private Button btn_r_ch_intro, btn_r_ws_intro, btn_r_pastor_intro, btn_r_team_intro, btn_r_circle_intro, btn_r_new_family_reg;
    private Button btn_r_gpt, btn_r_tbm, btn_r_sat_morn, btn_r_joseph, btn_r_live;
    private Button btn_r_main_event, btn_r_weekly_news, btn_r_upcoming_word, btn_r_survey, btn_r_album, btn_r_adv_video;
    private Button btn_r_weekly_pray, btn_r_pray_donation;
    private Button btn_r_dailybible, btn_r_adv_request, btn_r_place_reg, btn_r_car_reg, btn_r_map, btn_r_app_upload, btn_r_suggestion;
    private Button btn_r_facebook, btn_r_instagram, btn_r_homepage;
    private ImageButton btn_mnu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_sun_Text = new getText_Home();
        get_tbm_Text = new getText_Home();

        txt_sun = (TextView) findViewById(R.id.txt_sun);
        get_sun_Text.execute(txt_sun, txt_gpt_Url);

        txt_tbm = (TextView) findViewById(R.id.txt_tbm);
        get_tbm_Text.execute(txt_tbm, txt_tbm_Url);


        initSlideMenu();
    }


    //custom_actionbar로 바꾸기
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        ActionBar actionBar = getSupportActionBar();

        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.

        //layout을 가지고 와서 actionbar에 포팅.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.custom_actionbar, null);


        actionBar.setCustomView(actionbar);


        //액션바 양쪽 공백 없애기
        Toolbar parent = (Toolbar)actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);

        return true;
    }

    public void mnuClickEvent(View v){
        if(v.getId() == R.id.btn_mnu)
              menuRightSlideAnimationToggle();
    }

    private void initSlideMenu() {

        //우측 메뉴 클릭 후 들어간 상태가 아님
        move = false;

        // init left menu width
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        rightMenuWidth = (int) ((metrics.widthPixels) * 0.75);

        // init main view
        rr_mainLayout = (LinearLayout) findViewById(R.id.rr_mainlayout);

        // init right menu
        rr_menuLayout = (LinearLayout) findViewById(R.id.rr_menuLayout);
        rightMenuLayoutPrams = (FrameLayout.LayoutParams) rr_menuLayout
                .getLayoutParams();
        rightMenuLayoutPrams.width = rightMenuWidth;
        rr_menuLayout.setLayoutParams(rightMenuLayoutPrams);

        //지민 할 일 버튼들 초기화
        btn_r_ch_intro = (Button) findViewById(R.id.btn_r_ch_intro);
        btn_r_ws_intro = (Button) findViewById(R.id.btn_r_ws_intro);
        btn_r_pastor_intro = (Button) findViewById(R.id.btn_r_pastor_intro);
        btn_r_team_intro = (Button) findViewById(R.id.btn_r_team_intro);
        btn_r_circle_intro = (Button) findViewById(R.id.btn_r_circle_intro);
        btn_r_new_family_reg = (Button) findViewById(R.id.btn_r_new_family_reg);

        btn_r_gpt = (Button) findViewById(R.id.btn_r_gpt);
        btn_r_tbm = (Button) findViewById(R.id.btn_r_tbm);
        btn_r_sat_morn = (Button) findViewById(R.id.btn_r_sat_morn);
        btn_r_joseph = (Button) findViewById(R.id.btn_r_joseph);
        btn_r_live = (Button) findViewById(R.id.btn_r_live);


        btn_r_main_event = (Button) findViewById(R.id.btn_r_main_event);
        btn_r_weekly_news = (Button) findViewById(R.id.btn_r_weekly_news);
        btn_r_upcoming_word = (Button) findViewById(R.id.btn_r_upcoming_word);
        btn_r_survey = (Button) findViewById(R.id.btn_r_survey);
        btn_r_album = (Button) findViewById(R.id.btn_r_album);
        btn_r_adv_video = (Button) findViewById(R.id. btn_r_adv_video);

        btn_r_weekly_pray = (Button) findViewById(R.id.btn_r_weekly_pray);
        btn_r_pray_donation = (Button) findViewById(R.id.btn_r_pray_donation);

        btn_r_dailybible = (Button) findViewById(R.id.btn_r_dailybible);
        btn_r_adv_request = (Button) findViewById(R.id.btn_r_adv_request);
        btn_r_place_reg = (Button) findViewById(R.id.btn_r_place_reg);
        btn_r_car_reg = (Button) findViewById(R.id.btn_r_car_reg);
        btn_r_map = (Button) findViewById(R.id.btn_r_map);
        btn_r_app_upload = (Button) findViewById(R.id.btn_r_app_upload);
        btn_r_suggestion = (Button) findViewById(R.id.btn_r_suggestion);

        btn_r_homepage = (Button) findViewById(R.id.btn_r_homepage);
        btn_r_instagram = (Button) findViewById(R.id.btn_r_instagram);
        btn_r_facebook = (Button) findViewById(R.id.btn_r_facebook);


        btn_r_ch_intro.setEnabled(false);
        btn_r_ws_intro.setEnabled(false);
        btn_r_pastor_intro.setEnabled(false);
        btn_r_team_intro.setEnabled(false);
        btn_r_circle_intro.setEnabled(false);
        btn_r_new_family_reg.setEnabled(false);

        btn_r_gpt.setEnabled(false);
        btn_r_tbm.setEnabled(false);
        btn_r_sat_morn.setEnabled(false);
        btn_r_joseph.setEnabled(false);
        btn_r_live.setEnabled(false);

        btn_r_main_event.setEnabled(false);
        btn_r_weekly_news.setEnabled(false);
        btn_r_upcoming_word.setEnabled(false);
        btn_r_survey.setEnabled(false);
        btn_r_album.setEnabled(false);
        btn_r_adv_video.setEnabled(false);

        btn_r_weekly_pray.setEnabled(false);
        btn_r_pray_donation.setEnabled(false);

        btn_r_dailybible.setEnabled(false);
        btn_r_adv_request.setEnabled(false);
        btn_r_place_reg.setEnabled(false);
        btn_r_map.setEnabled(false);
        btn_r_app_upload.setEnabled(false);
        btn_r_suggestion.setEnabled(false);

        btn_r_homepage.setEnabled(false);
        btn_r_instagram.setEnabled(false);
        btn_r_facebook.setEnabled(false);



        btn_r_ch_intro.setOnClickListener(this);
        btn_r_ws_intro.setOnClickListener(this);
        btn_r_pastor_intro.setOnClickListener(this);
        btn_r_team_intro.setOnClickListener(this);
        btn_r_circle_intro.setOnClickListener(this);
        btn_r_new_family_reg.setOnClickListener(this);

        btn_r_gpt.setOnClickListener(this);
        btn_r_tbm.setOnClickListener(this);
        btn_r_sat_morn.setOnClickListener(this);
        btn_r_joseph.setOnClickListener(this);
        btn_r_live.setOnClickListener(this);

        btn_r_main_event.setOnClickListener(this);
        btn_r_weekly_news.setOnClickListener(this);
        btn_r_upcoming_word.setOnClickListener(this);
        btn_r_survey.setOnClickListener(this);
        btn_r_album.setOnClickListener(this);
        btn_r_adv_video.setOnClickListener(this);

        btn_r_weekly_pray.setOnClickListener(this);
        btn_r_pray_donation.setOnClickListener(this);


        btn_r_dailybible.setOnClickListener(this);
        btn_r_adv_request.setOnClickListener(this);
        btn_r_place_reg.setOnClickListener(this);
        btn_r_car_reg.setOnClickListener(this);
        btn_r_map.setOnClickListener(this);
        btn_r_app_upload.setOnClickListener(this);
        btn_r_suggestion.setOnClickListener(this);

        btn_r_homepage.setOnClickListener(this);
        btn_r_instagram.setOnClickListener(this);
        btn_r_facebook.setOnClickListener(this);
    }

    /**
     * right menu toggle
     */

    private void menuRightSlideAnimationToggle() {

        LinearLayout mainlayout = (LinearLayout) findViewById(R.id.rr_mainlayout);
        LinearLayout gray_layout = (LinearLayout) findViewById(R.id.gray_layout);

        //열고자 할 경우
        if (!isRightExpanded) {

            isRightExpanded = true;

            rr_mainLayout.setVisibility(View.GONE);
            gray_layout.bringToFront();

            // Expand
            new OpenAnimation(rr_mainLayout, rightMenuWidth,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, -0.75f, 0, 0.0f, 0, 0.0f);

            new OpenAnimation(gray_layout, rightMenuWidth,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, -0.75f, 0, 0.0f, 0, 0.0f);

            // enable all of menu view
            FrameLayout viewGroup = (FrameLayout) findViewById(R.id.rr_menuLayout)
                    .getParent();
            enableDisableViewGroup(viewGroup, true);

            // enable empty view
            ((LinearLayout) findViewById(R.id.rr_empty))
                    .setVisibility(View.VISIBLE);

            findViewById(R.id.rr_empty).setEnabled(true);
            findViewById(R.id.rr_empty).setOnTouchListener(
                    new View.OnTouchListener() {

                        @Override
                        public boolean onTouch(View arg0, MotionEvent arg1) {
                            menuRightSlideAnimationToggle();
                            return true;
                        }
                    });

        } else {
            isRightExpanded = false;

            gray_layout.bringToFront();

            new CloseAnimation(gray_layout, rightMenuWidth,
                    TranslateAnimation.RELATIVE_TO_SELF, -0.75f,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f, 450);


            // Collapse
            if(!move) {
                new CloseAnimation(rr_mainLayout, rightMenuWidth,
                        TranslateAnimation.RELATIVE_TO_SELF, -0.75f,
                        TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f, 450);
            }
            else {
                new CloseAnimation(rr_mainLayout, rightMenuWidth,
                        TranslateAnimation.RELATIVE_TO_SELF, -0.75f,
                        TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f, 0);
            }


            // enable all of menu view
            FrameLayout viewGroup = (FrameLayout) findViewById(R.id.rr_menuLayout)
                    .getParent();
            enableDisableViewGroup(viewGroup, false);

            mainlayout.bringToFront();

            ((LinearLayout) findViewById(R.id.rr_mainlayout))
                    .setVisibility(View.VISIBLE);

            // disable empty view
            ((LinearLayout) findViewById(R.id.rr_empty))
                    .setVisibility(View.GONE);
            findViewById(R.id.rr_empty).setEnabled(false);
        }
    }


    //메뉴가 나와있을 때 클릭가능
    public static void enableDisableViewGroup(ViewGroup viewGroup,
                                              boolean enabled) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {

            View view = viewGroup.getChildAt(i);
            view.setEnabled(enabled);

            view.setEnabled(enabled);
            if (view instanceof ViewGroup) {
                enableDisableViewGroup((ViewGroup) view, enabled);
            }

        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.not_move_activity, R.anim.not_move_activity);
    }

    @Override
    public void onClick(View v) {

        move = true;
        Intent intent = new Intent(this,ChosenPage.class);


        switch (v.getId()) {
           case R.id.btn_r_ch_intro:
               intent.putExtra("name","intro");
               intent.putExtra("name2", "intro_ch");
               startActivity(intent);
               menuRightSlideAnimationToggle();
               break;
            case R.id.btn_r_ws_intro:
                intent.putExtra("name","intro");
                intent.putExtra("name2", "intro_ws");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_pastor_intro:
                intent.putExtra("name","intro");
                intent.putExtra("name2", "intro_pastor");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_team_intro:
                intent.putExtra("name","intro");
                intent.putExtra("name2", "intro_team");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_circle_intro:
                intent.putExtra("name","intro2");
                intent.putExtra("name2", "intro_circle");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_new_family_reg:
                intent.putExtra("name","intro2");
                intent.putExtra("name2", "intro_new_family_reg");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            //예배
            case R.id.btn_r_gpt:
                intent.putExtra("name","ws");
                intent.putExtra("name2", "ws_gpt");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_tbm:
                intent.putExtra("name","ws");
                intent.putExtra("name2", "ws_tbm");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_sat_morn:
                intent.putExtra("name","ws");
                intent.putExtra("name2", "ws_sat_morn");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_joseph:
                intent.putExtra("name","ws");
                intent.putExtra("name2", "ws_joseph");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;

            case R.id.btn_r_live:
                intent.putExtra("name","ws2");
                intent.putExtra("name2", "ws_live");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;

            //공지
            case R.id.btn_r_main_event:
                intent.putExtra("name","notice");
                intent.putExtra("name2", "notice_main_event");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_weekly_news:
                intent.putExtra("name","notice");
                intent.putExtra("name2", "notice_weekly_news");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_upcoming_word:
                intent.putExtra("name","notice");
                intent.putExtra("name2", "notice_upcoming_word");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_survey:
                intent.putExtra("name","notice");
                intent.putExtra("name2", "notice_survey");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_album:
                intent.putExtra("name","notice2");
                intent.putExtra("name2", "notice_album");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_adv_video:
                intent.putExtra("name","notice2");
                intent.putExtra("name2", "notice_adv_video");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;

            //기도
            case R.id.btn_r_weekly_pray:
                intent.putExtra("name","pray");
                intent.putExtra("name2", "pray_weekly_pray");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_pray_donation:
                intent.putExtra("name","pray");
                intent.putExtra("name2", "pray_donation");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;


            //기타편의사항
            case R.id.btn_r_dailybible:
                intent.putExtra("name","etc");
                intent.putExtra("name2", "dailybible");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_adv_request:
                intent.putExtra("name","etc");
                intent.putExtra("name2", "adv_request");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_place_reg:
                intent.putExtra("name","etc");
                intent.putExtra("name2", "place_reg");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_car_reg:
                intent.putExtra("name","etc");
                intent.putExtra("name2", "car_reg");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_map:
                intent.putExtra("name","etc2");
                intent.putExtra("name2", "map");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_app_upload:
                intent.putExtra("name","etc2");
                intent.putExtra("name2", "app_upload");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;
            case R.id.btn_r_suggestion:
                intent.putExtra("name","etc2");
                intent.putExtra("name2", "suggestion");
                startActivity(intent);
                menuRightSlideAnimationToggle();
                break;

            //커뮤니티
            case R.id.btn_r_homepage:
                Intent com = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nsgrace.org/main/submain3.html"));
                menuRightSlideAnimationToggle();
                startActivity(com);
                finish();
                break;
            case R.id.btn_r_instagram:
                Intent com2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/nsg_youth/"));
                menuRightSlideAnimationToggle();
                startActivity(com2);
                finish();
                break;
            case R.id.btn_r_facebook:
                Intent com3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/NSGraceYouth/"));
                menuRightSlideAnimationToggle();
                startActivity(com3);
                finish();
                break;

        }

    }

}


