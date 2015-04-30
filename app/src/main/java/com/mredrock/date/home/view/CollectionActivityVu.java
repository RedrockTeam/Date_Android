package com.mredrock.date.home.view;

import android.support.v7.widget.LinearLayoutManager;

import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.widget.AppointmentArrayAdapter;

/**
 * Created by zhuchenxi on 15/4/29.
 */
public class CollectionActivityVu extends BaseActivityVu {
    private SuperRecyclerView mRecyclerView;
    private AppointmentArrayAdapter mAdapter;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_recyclerview);
        mRecyclerView = $(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AppointmentArrayAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.showProgress();
    }

    public void setAppointment(Appointment[] appointments){
        mRecyclerView.hideProgress();
        mRecyclerView.showRecycler();
        mAdapter.addAll(appointments);
    }

}
