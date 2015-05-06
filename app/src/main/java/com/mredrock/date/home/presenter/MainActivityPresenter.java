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
import com.mredrock.date.model.bean.Appointment;
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
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBindVu() {
        vu.addDrawer(this, new DrawerFragmentPresenter());
        mAdapter = new AppointmentArrayAdapter(this);
        mAdapter.addHeader(new MainHeader());
        vu.setRecyclerViewAdapter(mAdapter);
        vu.setOnRefreshListener(mRefreshListener);
        vu.setOnLoadMoreListener(onMoreListener);
        addAppointment(0);
        initUmengFamily();
    }

    private void initUmengFamily(){
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.enable();
        UmengUpdateAgent.update(this);
        Utils.Log(UmengRegistrar.getRegistrationId(this));
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
            startActivity(new Intent(this,EditActivityPresent.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
