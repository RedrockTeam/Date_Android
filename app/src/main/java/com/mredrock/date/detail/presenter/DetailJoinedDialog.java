package com.mredrock.date.detail.presenter;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.mredrock.date.R;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.DetailArrayAdapter;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class DetailJoinedDialog extends DialogFragment{
    private SuperRecyclerView recyclerView;
    private TextView sureBtn;

    private DetailArrayAdapter mAdapter;
    List<Detail.Join[]> joinedf = new ArrayList<Detail.Join[]>();

    public DetailJoinedDialog(List<Detail.Join[]> joinedf) {
        this.joinedf = joinedf;
    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(Utils.getScreenWidth() - Utils.dip2px(24), Utils.getScreenHeight() * 1 / 2);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
        mAdapter = new DetailArrayAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detailjoined_dialog, container, false);
        initView(root);
        return root;
    }

    private void initView(View root) {
        recyclerView = (SuperRecyclerView) root.findViewById(R.id.recyclerview);
        sureBtn = (TextView) root.findViewById(R.id.sure_detailjoined);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        mAdapter.clear();
        mAdapter.addAll(joinedf);

        sureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }
}
