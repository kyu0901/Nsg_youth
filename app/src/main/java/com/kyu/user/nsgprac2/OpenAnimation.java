package com.kyu.user.nsgprac2;

import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by hyk on 2018-01-18.
 */

public class OpenAnimation extends TranslateAnimation implements Animation.AnimationListener{

    private LinearLayout mainLayout;
    int panelWidth;

    public OpenAnimation(LinearLayout layout, int width, int fromXType,
                         float fromXValue, int toXType, float toXValue, int fromYType,
                         float fromYValue, int toYType, float toYValue) {

        super(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue,
                toYType, toYValue);

        // init
        mainLayout = layout;
        panelWidth = width;
        setDuration(450);       //열릴 때 속도
        setFillAfter(false);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
        mainLayout.startAnimation(this);
    }

    public void onAnimationEnd(Animation arg0) {

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainLayout.getLayoutParams();
        params.rightMargin = panelWidth;
        params.gravity = Gravity.RIGHT;
        mainLayout.clearAnimation();
        mainLayout.setLayoutParams(params);
        mainLayout.requestLayout();

    }

    public void onAnimationRepeat(Animation arg0) {

    }

    public void onAnimationStart(Animation arg0) {

    }

}
