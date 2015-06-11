package com.mredrock.date.letter.view;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.app.VuCallback;
import com.mredrock.date.model.bean.Letter;
import com.mredrock.date.widget.LoveView;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterDetailActivityVu extends BaseActivityVu implements View.OnClickListener {
    //TODO 用户头像跳转信息不正确
    private SimpleDraweeView sdvAvatar;
    private TextView tvUserName;
    private ImageView ivGender;
    private LoveView loveViewStar;
    private TextView tvContent;
    private Button btnReject;
    private Button btnReceive;
    private VuCallback vuCallback;

    @Override
    protected void onCreate() {
        setView(R.layout.activity_letter_detail);
        initView();
    }

    private void initView() {
        sdvAvatar = $(R.id.sdv_avatar);
        tvUserName = $(R.id.tv_user_name);
        ivGender = $(R.id.iv_gender);
        loveViewStar = $(R.id.lv_star);
        tvContent = $(R.id.tv_content);
        btnReject = $(R.id.btn_reject);
        btnReceive = $(R.id.btn_receive);
    }

    public void setData(Letter letter) {
        sdvAvatar.setImageURI(Uri.parse(letter.getUserAvatar()));
        tvUserName.setText(letter.getUserName());
        ivGender.setImageResource(getGenderImg(letter.getUserGender()));
        tvContent.setText("TA" + letter.getContent());
        btnReceive.setOnClickListener(this);
        btnReject.setOnClickListener(this);
        sdvAvatar.setOnClickListener(this);
//        setUserScore(letter.getUserScore());
        loveViewStar.setStart(letter.getUserScore());
    }

    private void setUserScore(double userScore) {
        boolean isHalf = false;
        int integer = (int) userScore;
        double delta = userScore - integer;
        if (delta > 0) {
            Log.d("TestDiv", "小数"+ userScore );
            isHalf = true;
        }
        if (isHalf) {
            loveViewStar.getChildAt(5).setVisibility(View.VISIBLE);
        } else {
            loveViewStar.getChildAt(5).setVisibility(View.GONE);
        }
        for (int i = 0; i < 11; i++) {
            if (i < 5 && i >= integer) {
                loveViewStar.getChildAt(i).setVisibility(View.GONE);
            }
            if (i > 5) {
                if (isHalf && (i - 5) > (5 - (integer + 1)) || !isHalf && (i - 5) > (5 - integer)) {
                    loveViewStar.getChildAt(i).setVisibility(View.GONE);
                    Log.d("setUserScore", i + "");
                }
            }
        }
    }

    public void showReject() {
        btnReject.setClickable(false);
        btnReject.setBackgroundColor(Color.parseColor("#f3f3f3"));
        btnReject.setText("已拒绝");
        btnReceive.setClickable(false);
        btnReceive.setBackgroundColor(Color.parseColor("#f3f3f3"));
    }

    public void showReceive() {
        btnReceive.setClickable(false);
        btnReceive.setBackgroundColor(Color.parseColor("#f3f3f3"));
        btnReceive.setText("已接受");
        btnReject.setClickable(false);
        btnReject.setBackgroundColor(Color.parseColor("#f3f3f3"));
    }

    public void showDefault() {
        btnReceive.setClickable(true);
        btnReject.setClickable(true);
        btnReceive.setBackgroundColor(Color.WHITE);
        btnReject.setBackgroundColor(Color.WHITE);
        btnReceive.setText("接受");
        btnReject.setText("拒绝");
    }

    public void setVuCallback(VuCallback vuCallback) {
        if (vuCallback != null) {
            this.vuCallback = vuCallback;
        }
    }

    private int getGenderImg(int genderId) {
        if (genderId == 1) {
            return R.drawable.ic_man;
        } else {
            return R.drawable.ic_woman;
        }
    }

    @Override
    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar) {
        super.onToolbarInit(act, toolbar);
        toolbar.setTitle(act.getString(R.string.activity_letter_detail));
    }

    @Override
    public void onClick(View v) {
        if (vuCallback != null) {
            vuCallback.onClick(v);
        }
    }
}
