package com.mredrock.date.letter.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.letter.view.LetterDetailActivityVu;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterDetailActivityPresenter extends BaseActivityPresenter<LetterDetailActivityVu>{

    @Override
    public Class<LetterDetailActivityVu> getVuClass() {
        return LetterDetailActivityVu.class;
    }

    @Override
    public void onBindVu() {
        super.onBindVu();
    }


}
