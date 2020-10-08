package com.mesh.emojiwall.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.jem.liquidswipe.clippathprovider.LiquidSwipeClipPathProvider;
import com.mesh.emojiwall.R;
import com.mesh.emojiwall.adapter.OnBoardingAdapter;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        //used for Touch Interactive:
        final ArrayList<LiquidSwipeClipPathProvider> liquidSwipeClipPathProviders = new ArrayList<>();
        liquidSwipeClipPathProviders.add(new LiquidSwipeClipPathProvider());
        liquidSwipeClipPathProviders.add(new LiquidSwipeClipPathProvider());
        liquidSwipeClipPathProviders.add(new LiquidSwipeClipPathProvider());
        liquidSwipeClipPathProviders.add(new LiquidSwipeClipPathProvider());
        liquidSwipeClipPathProviders.add(new LiquidSwipeClipPathProvider());

        //set adapter to view pager
        ViewPager viewpager = findViewById(R.id.viewpager);
        viewpager.setAdapter(new OnBoardingAdapter(this, liquidSwipeClipPathProviders));

        //animation according to touch event
        viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float y = motionEvent.getY();
                for (int i = 0; i < liquidSwipeClipPathProviders.size(); i++) {
                    liquidSwipeClipPathProviders.get(i).setWaveCenterY(y);
                }
                return false;
            }
        });

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingActivity.this, MainActivity.class));
            }
        });
    }
}