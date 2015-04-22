package com.mredrock.date.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.view.jpagerview.JPagerView;
import com.mredrock.date.R;
import com.mredrock.date.widget.RecyclerArrayAdapter;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class MainHeader implements RecyclerArrayAdapter.HeaderView {
    private View view;
    private JPagerView jpvBanner;

    @Override
    public View onCreateView(ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_main, parent, false);
        jpvBanner = (JPagerView) view.findViewById(R.id.jpv_banner);
        jpvBanner.setAdapter(new BannerPagerAdapter());
        return view;
    }

    @Override
    public void onBindView(View headerView) {

    }
}
