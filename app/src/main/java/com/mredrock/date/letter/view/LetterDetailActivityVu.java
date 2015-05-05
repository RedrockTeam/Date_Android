package com.mredrock.date.letter.view;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterDetailActivityVu extends BaseActivityVu{
    @Override
    protected void onCreate() {
        setView(R.layout.activity_letter_detail);
    }

    @Override
    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar) {
        super.onToolbarInit(act, toolbar);
        toolbar.setTitle(act.getString(R.string.activity_letter_detail));
    }
}
