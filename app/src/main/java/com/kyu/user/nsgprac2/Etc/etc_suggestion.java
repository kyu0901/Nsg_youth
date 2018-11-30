package com.kyu.user.nsgprac2.Etc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kyu.user.nsgprac2.R;

/**
 * Created by user on 2018-08-06.
 */
public class etc_suggestion extends Fragment {


    private WebView mWebView;           //웹뷰
    private WebSettings mWebSettings; //웹뷰 세팅

    public etc_suggestion() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.etc_suggestion, container, false);

        mWebView = (WebView) view.findViewById(R.id.etc_suggestion);
        mWebView.setWebViewClient(new WebViewClient());
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);

        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);

        mWebView.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //This is the filter
                if (event.getAction()!=KeyEvent.ACTION_DOWN)
                    return true;


                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    }else{
                        getActivity().onBackPressed();
                    }

                    return true;
                }

                return false;
            }
        });

        mWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdHDRaHWq7YhMFAU7wSSXvZvCen3Zm-jLwn4is0VmSRE0mLng/viewform");

        return view;
    }

}
