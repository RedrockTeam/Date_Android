package com.mredrock.date.setting.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.setting.view.QuestionActivityVu;

/**
 * Created by Mr.Jude on 2015/6/11.
 */
public class QuestionActivityPresenter extends BaseActivityPresenter<QuestionActivityVu> {
    @Override
    public Class<QuestionActivityVu> getVuClass() {
        return QuestionActivityVu.class;
    }

}
