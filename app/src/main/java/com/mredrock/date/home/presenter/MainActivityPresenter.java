package com.mredrock.date.home.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.MainHeader;
import com.mredrock.date.home.view.MainActivityVu;
import com.mredrock.date.model.AppointmentModel;
import com.mredrock.date.model.BannerModel;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Banner;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.AppointmentArrayAdapter;
import com.mredrock.date.widget.OnDataCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengRegistrar;
import com.umeng.update.UmengUpdateAgent;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainActivityPresenter extends BaseActivityPresenter<MainActivityVu> {
    private AppointmentArrayAdapter mAdapter;
    private AppointmentModel mAppointmentModel = new AppointmentModel();
    private int type,sort;
    private LoadAppointment mLoadAppointmentCallback = new LoadAppointment() {
        @Override
        public void loadAppointment(int type, int sort) {
            addAppointment(0, type, sort);
            MainActivityPresenter.this.type=type;
            MainActivityPresenter.this.sort=sort;
        }
    };
    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            addAppointment(0,type,sort);
        }
    };
    private OnMoreListener onMoreListener = new OnMoreListener() {
        @Override
        public void onMoreAsked(int i, int i1, int i2) {
            addAppointment(mAdapter.getPage(),type,sort);
        }
    };



    @Override
    public void onBindVu() {
        vu.addDrawer(this, new DrawerFragmentPresenter());
        mAdapter = new AppointmentArrayAdapter(this);
        getBanners();
        vu.setRecyclerViewAdapter(mAdapter);
        vu.setOnRefreshListener(mRefreshListener);
        vu.setOnLoadMoreListener(onMoreListener);
        addAppointment(0,type,sort);
        initUmengFamily();
    }

    private void getBanners(){
        new BannerModel().getBannerListFromServer(new OnDataCallback<Banner>() {
            @Override
            public void callback(Banner... list) {
                mAdapter.addHeader(new MainHeader(list,mLoadAppointmentCallback));
            }

            @Override
            public void error(String info) {
                mAdapter.addHeader(new MainHeader(null,mLoadAppointmentCallback));
            }
        });
    }

    private void initUmengFamily(){
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.enable();
        UmengUpdateAgent.update(this);
        Utils.Log(UmengRegistrar.getRegistrationId(this));
    }


    private void addAppointment(final int page,int type,int sort){
        mAppointmentModel.getAppointmentFromServer(page,type,sort, new OnDataCallback<Appointment>() {
            @Override
            public void callback(Appointment... list) {
                vu.finishLoading();
                if (page == 0)mAdapter.clear();
                mAdapter.addAll(list);
            }

            @Override
            public void error(String info) {

            }
        });
    }
    public interface LoadAppointment{
        public void loadAppointment(int type,int sort);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public Class<MainActivityVu> getVuClass() {
        return MainActivityVu.class;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add){
            startActivityForResult(new Intent(this, EditActivityPresent.class), 1000);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000&& resultCode == RESULT_OK)
        addAppointment(0,type,sort);
    }
}
