package com.mredrock.date.home;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jude.view.jpagerview.JPagerView;
import com.mredrock.date.R;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.RecyclerArrayAdapter;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class MainHeader implements RecyclerArrayAdapter.HeaderView ,View.OnClickListener{
    private View view;
    private JPagerView jpvBanner;
    private View mSelectGroup;

    @Override
    public View onCreateView(ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_main, parent, false);
        jpvBanner = (JPagerView) view.findViewById(R.id.jpv_banner);
        jpvBanner.setAdapter(new BannerPagerAdapter());
        view.findViewById(R.id.btn_type).setOnClickListener(this);
        view.findViewById(R.id.btn_sort).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_type:
                showTypeSelectView(v.getContext());
                break;
            case R.id.btn_sort:
                showSortSelectView(v.getContext());
                break;
        }
    }

    private void showTypeSelectView(final Context ctx){
        GridView gridView = new GridView(ctx);
        gridView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        gridView.setNumColumns(3);
        gridView.setBackgroundColor(Color.WHITE);
        gridView.setHorizontalSpacing(Utils.dip2px(0.5f));
        gridView.setVerticalSpacing(Utils.dip2px(0.5f));
        gridView.setPadding(Utils.dip2px(0.5f),Utils.dip2px(0.5f),Utils.dip2px(0.5f),Utils.dip2px(0.5f));

        final PopupWindow finalMPopupWindow = createPopupWindow(gridView, Utils.dip2px(56) * 3 + Utils.dip2px(0.5f) * 3);
        finalMPopupWindow.showAsDropDown(mSelectGroup);

        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return ctx.getResources().getStringArray(R.array.style).length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                TextView view = new TextView(parent.getContext());
                view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,Utils.dip2px(56)));
                view.setBackgroundColor(Color.WHITE);
                view.setGravity(Gravity.CENTER);
                view.setText(ctx.getResources().getStringArray(R.array.style)[position]);
                view.setBackgroundResource(R.drawable.line_round);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.Toast(ctx.getResources().getStringArray(R.array.style)[position]);
                        finalMPopupWindow.dismiss();
                    }
                });
                return view;
            }
        });
    }

    private void showSortSelectView(final Context ctx){
        ListView listView = new ListView(ctx);
        listView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        listView.setBackgroundColor(Color.WHITE);

        final PopupWindow finalMPopupWindow = createPopupWindow(listView, Utils.dip2px(56) * 3 + Utils.dip2px(0.5f) * 3);
        finalMPopupWindow.showAsDropDown(mSelectGroup);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return ctx.getResources().getStringArray(R.array.sort).length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                TextView view = new TextView(parent.getContext());
                view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,Utils.dip2px(48)));
                view.setBackgroundColor(Color.WHITE);
                view.setGravity(Gravity.CENTER);
                view.setText(ctx.getResources().getStringArray(R.array.sort)[position]);
                view.setBackgroundColor(Color.WHITE);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.Toast(ctx.getResources().getStringArray(R.array.sort)[position]);
                        finalMPopupWindow.dismiss();
                    }
                });
                return view;
            }
        });
    }


    private PopupWindow createPopupWindow(View view, int height){
        LinearLayout layout = new LinearLayout(view.getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(view);

        View shadowView = new View(view.getContext());
        shadowView.setBackgroundResource(R.drawable.bottom_shadow);
        shadowView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,Utils.dip2px(4)));
        layout.addView(shadowView);

        PopupWindow mPopupWindow = new PopupWindow(layout, Utils.getScreenWidth(),height+Utils.dip2px(4));
        mPopupWindow.setBackgroundDrawable(view.getContext().getResources().getDrawable(android.R.color.transparent));
        mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        mPopupWindow.update();
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);
        return mPopupWindow;
    }



    @Override
    public void onBindView(View headerView) {
        mSelectGroup = headerView.findViewById(R.id.select_group);
    }

}
