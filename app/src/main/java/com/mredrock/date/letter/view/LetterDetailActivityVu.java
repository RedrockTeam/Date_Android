package com.mredrock.date.letter.view;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.app.VuCallback;
import com.mredrock.date.model.bean.Letter;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterDetailActivityVu extends BaseActivityVu implements View.OnClickListener {
    private SimpleDraweeView sdvAvatar;
    private TextView tvUserName;
    private ImageView ivGender;
    private ViewGroup llUserStarContainer;
    private TextView tvContent;
    private Button btnReject;
    private Button btnReceive;
    private Letter letter;
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
        llUserStarContainer = $(R.id.ll_user_star_container);
        tvContent = $(R.id.tv_content);
        btnReject = $(R.id.btn_reject);
        btnReceive = $(R.id.btn_receive);

    }

    public void setData(Letter letter) {
        this.letter = letter;
        //TODO 设置数据
        sdvAvatar.setImageURI(Uri.parse(letter.getUserAvatar()));
        tvUserName.setText(letter.getUserName());
        ivGender.setImageResource(getGenderImg(letter.getUserGender()));
        tvContent.setText(letter.getContent());
        btnReceive.setOnClickListener(this);
        btnReject.setOnClickListener(this);
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
        this.vuCallback = vuCallback;
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
