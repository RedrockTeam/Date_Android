package com.mredrock.date.detail.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.DetailMode;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.DetailArrayAdapter;
import com.mredrock.date.widget.OnDataCallback;

import java.util.List;

public class DetailActivityVu extends BaseActivityVu implements View.OnClickListener {
    private SuperRecyclerView mRecyclerView;
    private DetailArrayAdapter mAdapter;
    private TextView collectionBtn;
    private TextView reportBtn;

    private Appointment data;
    private DetailMode detailMode = new DetailMode();

    @Override
    protected void onCreate() {
        setView(R.layout.activity_detail);
        mRecyclerView = $(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        collectionBtn = (TextView) rootView.findViewById(R.id.collection_detail);
        reportBtn = (TextView) rootView.findViewById(R.id.report_detail);
        collectionBtn.setOnClickListener(this);
        reportBtn.setOnClickListener(this);
    }

    public void setDetailAdapter(DetailArrayAdapter mAdapter) {
        this.mAdapter = mAdapter;
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setLoadDetail(String json) {
        if (json != null) {
            data = JSON.parseObject(json, Appointment.class);
        }
        mAdapter.addHeader(new DetailHeader(data, this));
    }

    public void headBackView(int collection_status, int apply_status, List<Detail.Join[]> joined) {
        mAdapter.clear();
        mAdapter.addAll(joined);
        collectionBtn.setText(Detail.COLLECTION[collection_status]);
        reportBtn.setText(Detail.REPORT[apply_status]);
        if (apply_status != 0) {
            reportBtn.setClickable(false);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.collection_detail:
                if (collectionBtn.getText().toString().equals(Detail.COLLECTION[0])) {
                    detailMode.getCollectionFromServer(data.getDate_id(), new OnDataCallback<String>() {
                        @Override
                        public void callback(String... list) {
                            Utils.Toast(list[0]);
                            collectionBtn.setText(Detail.COLLECTION[1]);
                        }

                        @Override
                        public void error(String info) {
                            Utils.Toast(info);
                        }
                    });
                } else {
                    detailMode.getCancelCollectionFromService(data.getDate_id(), new OnDataCallback<String>() {
                        @Override
                        public void callback(String... list) {
                            Utils.Toast(list[0]);
                            collectionBtn.setText(Detail.COLLECTION[0]);
                        }

                        @Override
                        public void error(String info) {
                            Utils.Toast(info);
                        }
                    });
                }
                break;
            case R.id.report_detail:
                detailMode.getReportFromService(data.getDate_id(), new OnDataCallback<String>() {
                    @Override
                    public void callback(String... list) {
                        reportBtn.setText(Detail.REPORT[1]);
                        reportBtn.setClickable(false);
                    }

                    @Override
                    public void error(String info) {
                        Utils.Toast(info);
                    }
                });
                break;
        }
    }
}
