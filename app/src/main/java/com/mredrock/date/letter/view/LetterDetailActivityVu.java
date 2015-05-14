package com.mredrock.date.letter.view;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.bean.Letter;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterDetailActivityVu extends BaseActivityVu{
    private SimpleDraweeView sdvAvatar;
    private TextView tvUserName;
    private ImageView ivGender;
    private ViewGroup llUserStarContainer;
    private TextView tvContent;
    private Button btnReject;
    private Button btnReceive;
    private Letter letter;


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
        sdvAvatar.setImageURI(Uri.parse(letter.getUserAvatar()));
        tvUserName.setText(letter.getUserName());
        ivGender.setImageResource(getGenderImg(letter.getUserGender()));
        tvContent.setText(letter.getContent());
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
}
