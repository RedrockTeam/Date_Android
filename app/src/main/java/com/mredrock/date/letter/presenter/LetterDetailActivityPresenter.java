package com.mredrock.date.letter.presenter;

import android.view.Menu;
import android.view.MenuItem;

import com.mredrock.date.R;
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
