package com.mredrock.date.letter.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.letter.view.LetterActivityVu;
import com.mredrock.date.letter.view.LetterViewHolder;
import com.mredrock.date.model.bean.Letter;
import com.mredrock.date.widget.BaseViewHolder;
import com.mredrock.date.widget.RecyclerArrayAdapter;

/**
 * Created by Lecion on 4/28/15.
 */
public class LetterActivityPresenter extends BaseActivityPresenter<LetterActivityVu>{
    private RecyclerView.Adapter letterAdapter;


    @Override
    public Class<LetterActivityVu> getVuClass() {
        return LetterActivityVu.class;
    }

    @Override
    public void onBindVu() {
        //TODO 这里做View的初始化操作，如准备数据，设置adapter，设置下拉刷新上拉加载状态等等与vu相关的操作

    }


    /**
     * 私信列表适配器
     */
    class LetterAdapter extends RecyclerArrayAdapter<Letter> {

        public LetterAdapter(Context context) {
            super(context);
        }

        @Override
        public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            return new LetterViewHolder(parent);
        }

        @Override
        public void OnBindViewHolder(BaseViewHolder holder, int position) {
            holder.setData(getItem(position));
        }
    }
}
