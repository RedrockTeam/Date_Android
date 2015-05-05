package com.mredrock.date.letter.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;

/**
 * Created by Lecion on 4/28/15.
 */
public class LetterActivityVu extends BaseActivityVu {
    private SuperRecyclerView rvLetter = null;

    @Override
    protected void onCreate() {
        setView(R.layout.activity_letter);
        rvLetter = $(R.id.recyclerview);
        rvLetter.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    @Override
    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar) {
        super.onToolbarInit(act, toolbar);
        toolbar.setTitle(getContext().getResources().getString(R.string.activity_letter));
    }

    /**
     * 隐藏所有进度条
     */
    public void hideProgress() {
        rvLetter.hideMoreProgress();
        rvLetter.hideProgress();
    }

    /**
     * 设置适配器
     * @param adapter
     */
    public void setLetterAdapter(RecyclerView.Adapter adapter) {
        rvLetter.setAdapter(adapter);
    }

    /**
     * 设置刷新监听器
     * @param listener
     */
    public void setRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        rvLetter.setRefreshListener(listener);
    }

    /**
     * 设置加载更多监听器
     * @param lisenter
     */
    public void setOnMoreListener(OnMoreListener lisenter) {
        rvLetter.setOnMoreListener(lisenter);
    }
}
