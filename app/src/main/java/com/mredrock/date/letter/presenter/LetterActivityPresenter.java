package com.mredrock.date.letter.presenter;

import android.content.Context;
import android.content.Intent;
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
    public static int REQUEST_LETTER = 1;

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
        addLetters(0);
        refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                addLetters(0);
            }
        };
        onMoreListener = new OnMoreListener() {
            @Override
            public void onMoreAsked(int i, int i2, int i3) {
                addLetters(letterAdapter.getPage());
                Log.d("LetterActivityPresenter", "addLetters" + letterAdapter.getPage() + "  itemCount " + letterAdapter.getItemCount() + String.format("i = %s i2 = %s i3 = %s", i, i2, i3));
            }
        };
    }

    private void addLetters(final int page) {

        letterModel.getLetters(page, new NetworkCallback<Letter[]>() {

            @Override
            protected void pre() {

            }

            @Override
            protected void success(Letter[] data) {
                Log.d("success", data.toString());
                if (page == 0) {
                    letterAdapter.clear();
                }
                //请求到的数据为空
                if (data.length < 1) {
                    //做提示操作：0页的时候暂无私信，非0页的时候，提示没有更多数据加载
                } else {
                    letterAdapter.addAll(data);
                }
            }

            @Override
            protected void error(int errCode, String info) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LETTER && resultCode == LetterDetailActivityPresenter.RESULT_LETTER) {
//            Log.d("onActivityResult", "position" + data.getIntExtra("position", -1) + " \n" + data.getParcelableExtra("letter") + " isChange " + data.getBooleanExtra("flag", false));
            int position = data.getIntExtra("position", -1);
            Letter letter = data.getParcelableExtra("letter");
            letterAdapter.getItem(position).setUserDateStatus(letter.getUserDateStatus());
            letterAdapter.notifyDataSetChanged();
        }
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
            ((LetterViewHolder)holder).setData(getItem(position), position);
        }


    }
}
