package com.mredrock.date.home.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.config.C;
import com.mredrock.date.detail.presenter.DetailActivityPresenter;
import com.mredrock.date.home.presenter.DrawerFragmentPresenter;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.RecyclerArrayAdapter;

/**
 * Created by Mr.Jude on 2015/4/21.
 */
public class MainActivityVu extends BaseActivityVu implements RecyclerArrayAdapter.OnRecyclerItemClickListener {
    private SuperRecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout drawerLayout;

    private RecyclerArrayAdapter adapter;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_main);
        drawerLayout = $(R.id.drawerLayout);
        recyclerView = $(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setRecyclerViewAdapter(RecyclerView.Adapter adapter) {
        this.adapter = (RecyclerArrayAdapter) adapter;
        recyclerView.setAdapter(adapter);
        this.adapter.setOnRecyclerOnClickListener(this);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        recyclerView.setRefreshListener(listener);
    }

    public void setOnLoadMoreListener(OnMoreListener listener) {
        recyclerView.setOnMoreListener(listener);
    }

    public void finishLoading() {
        recyclerView.hideMoreProgress();
        recyclerView.hideProgress();
    }

    public void addDrawer(final ActionBarActivity act, DrawerFragmentPresenter presenter) {
        mDrawerToggle = new ActionBarDrawerToggle(act, drawerLayout, getToolbar(), R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                act.invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {

                act.invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };
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
        act.getSupportFragmentManager().beginTransaction().add(R.id.drawer, presenter, "drawer").commit();
    }


    public boolean onDrawerToggleSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return false;
    }

    public void onPostCreate() {
        mDrawerToggle.syncState();
    }


    public void onConfigurationChanged(Configuration newConfig) {
        mDrawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent();
        intent.setClass(context, DetailActivityPresenter.class);
        intent.putExtra(C.DETAIL_TAG, new Gson().toJson(adapter.getItem(position)));
        context.startActivity(intent);
    }
}
