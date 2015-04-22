package com.mredrock.date.home.presenter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.MainHeader;
import com.mredrock.date.home.view.MainActivityVu;
import com.mredrock.date.model.AppointmentModel;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.AppointmentArrayAdapter;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainActivityPresenter extends BaseActivityPresenter<MainActivityVu> {
    private AppointmentArrayAdapter mAdapter;
    private AppointmentModel mAppointmentModel = new AppointmentModel();
    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            addAppointment(0);
        }
    };
    private OnMoreListener onMoreListener = new OnMoreListener() {
        @Override
        public void onMoreAsked(int i, int i1, int i2) {
            addAppointment(mAdapter.getPage());
            Utils.Log("i:"+i+"  i1:"+i1 +"  i2:"+i2);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vu.addDrawer(this, new DrawerFragmentPresenter());
        mAdapter = new AppointmentArrayAdapter(this);
        mAdapter.addHeader(new MainHeader());
        vu.setRecyclerViewAdapter(mAdapter);
        vu.setOnRefreshListener(mRefreshListener);
        vu.setOnLoadMoreListener(onMoreListener);
        addAppointment(0);
    }


    private void addAppointment(final int page){
        mAppointmentModel.getAppointmentFromServer(page, new OnDataCallback<Appointment>() {
            @Override
            public void callback(Appointment... list) {
                vu.finishLoading();
                if (page == 0)mAdapter.clear();
                mAdapter.addAll(list);
            }
        });
    }

    @Override
    public Class<MainActivityVu> getVuClass() {
        return MainActivityVu.class;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (vu.onDrawerToggleSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        vu.onPostCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        vu.onConfigurationChanged(newConfig);
    }

}
