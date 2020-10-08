package com.mesh.emojiwall.adapter;

import android.content.Context;
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

    private final int[] colorArray;
    private final String[] titleArray, subTitleArray;

    public OnBoardingAdapter(Context context, ArrayList<LiquidSwipeClipPathProvider> liquidSwipeClipPathProviders) {
        this.context = context;
        this.liquidSwipeClipPathProviders = liquidSwipeClipPathProviders;
        this.titleArray = context.getResources().getStringArray(R.array.on_boarding_titles);
        this.subTitleArray = context.getResources().getStringArray(R.array.on_boarding_sub_titles);
        this.colorArray = context.getResources().getIntArray(R.array.on_boarding_colors);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View layout = LayoutInflater.from(context).inflate(R.layout.fragment_on_boarding, container, false);

        layout.setBackgroundColor(colorArray[position]);

        TextView tvTitle = layout.findViewById(R.id.tvTitle);
        TextView tvSubTitle = layout.findViewById(R.id.tvSubTitle);

        tvTitle.setText(titleArray[position]);
        tvSubTitle.setText(subTitleArray[position]);

        if (position == 0) {
            tvTitle.setTextColor(context.getResources().getColor(R.color.black));
            tvSubTitle.setTextColor(context.getResources().getColor(R.color.black));
        } else {
            tvTitle.setTextColor(context.getResources().getColor(R.color.white));
            tvSubTitle.setTextColor(context.getResources().getColor(R.color.white));
        }

        if (layout instanceof LiquidSwipeLayout) {
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
