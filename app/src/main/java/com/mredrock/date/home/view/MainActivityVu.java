package com.mredrock.date.home.view;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.home.presenter.DrawerFragmentPresenter;
import com.mredrock.date.util.Utils;

/**
 * Created by Mr.Jude on 2015/4/21.
 */
public class MainActivityVu extends BaseActivityVu {
    private SuperRecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_main);
        drawerLayout = $(R.id.drawerLayout);
        recyclerView = $(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setRecyclerViewAdapter(RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener){
        recyclerView.setRefreshListener(listener);
    }

    public void setOnLoadMoreListener(OnMoreListener listener){
        recyclerView.setOnMoreListener(listener);
    }

    public void finishLoading(){
        recyclerView.hideMoreProgress();
        recyclerView.hideProgress();
    }

    public void addDrawer(final ActionBarActivity act,DrawerFragmentPresenter presenter){
        mDrawerToggle = new ActionBarDrawerToggle(act, drawerLayout, getToolbar(), R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(mDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        final View container = $(R.id.drawer);
        container.post(new Runnable() {
            @Override
            public void run() {
                Utils.resizeView(container, Utils.getScreenWidth() - Utils.dip2px(56), ViewGroup.LayoutParams.MATCH_PARENT);
            }
        });
        act.getSupportFragmentManager().beginTransaction().add(R.id.drawer,presenter,"drawer").commit();
    }
}
