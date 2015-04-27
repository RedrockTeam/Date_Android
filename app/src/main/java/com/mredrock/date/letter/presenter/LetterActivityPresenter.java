package com.mredrock.date.letter.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.letter.view.LetterActivityVu;

/**
 * Created by Lecion on 4/28/15.
 */
public class LetterActivityPresenter extends BaseActivityPresenter<LetterActivityVu>{
    @Override
    public Class<LetterActivityVu> getVuClass() {
        return LetterActivityVu.class;
    }

    @Override
    public void onBindVu() {
        //TODO 这里做View的初始化操作，如准备数据，设置adapter，设置下拉刷新上拉加载状态等等与vu相关的操作

    }
}
