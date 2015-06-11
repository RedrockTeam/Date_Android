package com.mredrock.date.letter.presenter;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.VuCallback;
import com.mredrock.date.information.view.presenter.InfoActivityPresenter;
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
                    doReceive();
                } else if (view.getId() == R.id.btn_reject) {
                    doReject();
                } else if (view.getId() == R.id.sdv_avatar) {
                    goInfoActivity();
                }
            }
        });
        setResult(letter);
    }

    private void goInfoActivity() {
        Intent i = new Intent(this, InfoActivityPresenter.class);
        i.putExtra("uid", letter.getUserId());
        startActivity(i);
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
                Log.d("doReject", data);
                letter.setUserDateStatus(Letter.UserDataStatus.REJECT);
                isChange = true;
                vu.showReject();
                setResult(letter);
            }

            @Override
            protected void error(int errCode, String info) {

            }
        });

    }

    public void doReceive() {
        letterModel.dateAction(letter.getDateId(), letter.getUserId(), Letter.UserDataStatus.RECEIVE, new NetworkCallback<String>() {

            @Override
            protected void pre() {

            }

            @Override
            protected void success(String data) {
                Log.d("doReceive", data);
                letter.setUserDateStatus(Letter.UserDataStatus.RECEIVE);
                isChange = true;
                vu.showReceive();
                setResult(letter);
            }

            @Override
            protected void error(int errCode, String info) {
                Toast.makeText(getApplicationContext(), "网络异常，请检查网络设置！", Toast.LENGTH_LONG).show();
            }
        });
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
