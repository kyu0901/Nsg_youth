package com.kyu.user.nsgprac2;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by hyk on 2018-01-18.
 */

public class CloseAnimation extends TranslateAnimation implements TranslateAnimation.AnimationListener {

    private LinearLayout mainLayout;
    int panelWidth;

    public CloseAnimation(LinearLayout layout, int width, int fromXType,
                          float fromXValue, int toXType, float toXValue, int fromYType,
                          float fromYValue, int toYType, float toYValue, int dur) {

        super(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue,
                toYType, toYValue);

        // Initialize
        mainLayout = layout;
        panelWidth = width;
        setDuration(dur);
        setFillAfter(false);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);

        // Clear left and right margins
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainLayout.getLayoutParams();
        params.rightMargin = 0;
        params.leftMargin = 0;
        mainLayout.setLayoutParams(params);
        mainLayout.requestLayout();
        mainLayout.startAnimation(this);

    }

    public void onAnimationEnd(Animation animation) {

    }

    public void onAnimationRepeat(Animation animation) {

    }

    public void onAnimationStart(Animation animation) {

    }

}
