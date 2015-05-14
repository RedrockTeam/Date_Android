package com.mredrock.date.letter.presenter;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.VuCallback;
import com.mredrock.date.letter.view.LetterDetailActivityVu;
import com.mredrock.date.model.bean.Letter;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterDetailActivityPresenter extends BaseActivityPresenter<LetterDetailActivityVu>{

    public static final String TAG = "LetterDetailActivityPresenter";

    @Override
    public Class<LetterDetailActivityVu> getVuClass() {
        return LetterDetailActivityVu.class;
    }

    @Override
    public void onBindVu() {
        super.onBindVu();
        Intent i = getIntent();
        final Letter letter =  i.getParcelableExtra("letter");
        vu.setData(letter);
        switch (letter.getUserDateStatus()) {
            case Letter.UserDataStatus.RECEIVE:
                vu.showReceive();
                break;
            case Letter.UserDataStatus.REJECT:
                vu.showReject();
                break;
            case Letter.UserDataStatus.DEFAULT:
                vu.showDefault();
        }

        vu.setVuCallback(new VuCallback() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_receive) {
                    letter.setUserDateStatus(Letter.UserDataStatus.RECEIVE);
                    vu.showReceive();
                } else if (view.getId() == R.id.btn_reject) {
                    letter.setUserDateStatus(Letter.UserDataStatus.REJECT);
                    vu.showReject();
                }
            }
        });
        Log.d(TAG, letter.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_letter_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}
