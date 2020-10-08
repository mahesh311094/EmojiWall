package com.mesh.emojiwall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.jem.liquidswipe.base.LiquidSwipeLayout;
import com.jem.liquidswipe.clippathprovider.LiquidSwipeClipPathProvider;
import com.mesh.emojiwall.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OnBoardingAdapter extends PagerAdapter {

    private final Context context;
    private final ArrayList<LiquidSwipeClipPathProvider> liquidSwipeClipPathProviders;

    private static final int[] backgroundColorArray = new int[]{Color.parseColor("#6200EE"), Color.parseColor("#9FD29D"), Color.parseColor("#AFE1F0"), Color.parseColor("#F6D336"), Color.parseColor("#FA796B")};
    private static final String[] titleArray = new String[]{"Hello fellow developer", "If you like this library", "Then do star it", "And check out my other libraries", "Cheers ^_^"};

    public OnBoardingAdapter(Context context, ArrayList<LiquidSwipeClipPathProvider> liquidSwipeClipPathProviders) {
        this.context = context;
        this.liquidSwipeClipPathProviders = liquidSwipeClipPathProviders;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View layout = LayoutInflater.from(context).inflate(R.layout.fragment_on_boarding, container, false);
        layout.setBackgroundColor(backgroundColorArray[position]);
        TextView tv = layout.findViewById(R.id.fragment_textview);
        tv.setText(titleArray[position]);

        if(layout instanceof LiquidSwipeLayout) {
            LiquidSwipeLayout liquidSwipeLayout = (LiquidSwipeLayout) layout;
            liquidSwipeLayout.setClipPathProvider(liquidSwipeClipPathProviders.get(position));
        }
        container.addView(layout);
        return layout;
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
