package com.example.kswook.empty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kswook.empty.view.SlidingPageView;

public class MainActivity extends AppCompatActivity {

    ViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewGroup = (ViewGroup) findViewById(R.id.activity_main);

        final SlidingPageView slidingPageView = (SlidingPageView) LayoutInflater.from(this).inflate(R.layout.v_content, viewGroup, false);
        slidingPageView.setSliderFadeColor(0);
        viewGroup.addView(slidingPageView);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slidingPageView.isOpen()){
                    slidingPageView.setVisibility(View.VISIBLE);
                    slidingPageView.closePane();
                }else {
                    slidingPageView.openPane();
                }
            }
        });
    }
}
