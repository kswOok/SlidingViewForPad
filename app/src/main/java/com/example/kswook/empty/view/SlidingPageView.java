package com.example.kswook.empty.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.kswook.empty.R;

/**
 * Created by kswook on 15/01/2017.
 */

public class SlidingPageView extends SlidingPaneLayout {

    private static final int DEFAULT_OVERHANG_SIZE = 0; // dp;


    public SlidingPageView(Context context) {
        super(context);
    }

    public SlidingPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidingPageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {

        final View shadowView = findViewById(R.id.shadow);
        shadowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openPane();
            }
        });
        setPanelSlideListener(new PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i("onPanelSlide", "======" + slideOffset);
                ViewCompat.setAlpha(shadowView,
                        1.0f - slideOffset);
            }

            @Override
            public void onPanelOpened(View panel) {
                Log.i("onPanelSlide", "======onPanelOpened");
                SlidingPageView.this.setVisibility(GONE);

            }

            @Override
            public void onPanelClosed(View panel) {


                Log.i("onPanelSlide", "======onPanelClosed");

            }
        });

    }


}
