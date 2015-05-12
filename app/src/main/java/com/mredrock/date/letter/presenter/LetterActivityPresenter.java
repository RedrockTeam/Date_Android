package com.mredrock.date.letter.presenter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.letter.view.LetterActivityVu;
import com.mredrock.date.letter.view.LetterViewHolder;
import com.mredrock.date.model.LetterModel;
import com.mredrock.date.model.NetworkCallback;
import com.mredrock.date.model.bean.Letter;
import com.mredrock.date.widget.BaseViewHolder;
import com.mredrock.date.widget.RecyclerArrayAdapter;

/**
 * Created by Lecion on 4/28/15.
 */
public class LetterActivityPresenter extends BaseActivityPresenter<LetterActivityVu>{
    private LetterAdapter letterAdapter;
    private SwipeRefreshLayout.OnRefreshListener refreshListener;
    private OnMoreListener onMoreListener;
    private LetterModel letterModel;
    private int page = 1;

    @Override
    public Class<LetterActivityVu> getVuClass() {
        return LetterActivityVu.class;
    }

    @Override
    public void onBindVu() {
        initData();
        vu.setLetterAdapter(letterAdapter);
        vu.setRefreshListener(refreshListener);
        vu.setOnMoreListener(onMoreListener);
    }

    private void initData() {
        letterModel = new LetterModel();
        letterAdapter = new LetterAdapter(this);
        refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        };
        onMoreListener = new OnMoreListener() {
            @Override
            public void onMoreAsked(int i, int i2, int i3) {

            }
        };
        letterModel.getLetters(page, new NetworkCallback<Letter[]>() {

            @Override
            protected void pre() {

            }

            @Override
            protected void success(Letter[] data) {
                Log.d("success", data.toString());
                letterAdapter.addAll(data);
            }

            @Override
            protected void error(int errCode, String info) {

            }
        });

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
