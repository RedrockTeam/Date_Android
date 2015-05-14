package com.mredrock.date.letter.presenter;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.VuCallback;
import com.mredrock.date.letter.view.LetterDetailActivityVu;
import com.mredrock.date.model.LetterModel;
import com.mredrock.date.model.NetworkCallback;
import com.mredrock.date.model.bean.Letter;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterDetailActivityPresenter extends BaseActivityPresenter<LetterDetailActivityVu>{
    private LetterModel letterModel;

    public static final String TAG = "LetterDetailActivityPresenter";

    public static int RESULT_LETTER = 1;

    private boolean isChange = false;

    private int position;
    private Letter letter;

    @Override
    public Class<LetterDetailActivityVu> getVuClass() {
        return LetterDetailActivityVu.class;
    }

    @Override
    public void onBindVu() {
        super.onBindVu();
        Intent i = getIntent();
        letterModel = new LetterModel();
        letter =  i.getParcelableExtra("letter");
        position = i.getIntExtra("position", -1);
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
                    setResult(letter);
                    vu.showReceive();
                    isChange = true;
                } else if (view.getId() == R.id.btn_reject) {
                    letter.setUserDateStatus(Letter.UserDataStatus.REJECT);
                    isChange = true;
                    vu.showReject();
                    setResult(letter);
                }
            }
        });
        setResult(letter);
    }

    public void setResult(Letter letter) {
        Intent intent = new Intent();
        intent.putExtra("flag", isChange);
        intent.putExtra("position", position);
        intent.putExtra("letter", letter);
        setResult(RESULT_LETTER, intent);
    }

    public void doReject() {
        letterModel.dateAction(letter.getDateId(), letter.getUserId(), Letter.UserDataStatus.REJECT, new NetworkCallback<String>() {

            @Override
            protected void pre() {

            }

            @Override
            protected void success(String data) {

            }

            @Override
            protected void error(int errCode, String info) {

            }
        });

    }

    public void doReceive() {

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
