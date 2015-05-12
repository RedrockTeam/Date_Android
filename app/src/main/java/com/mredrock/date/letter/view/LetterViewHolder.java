package com.mredrock.date.letter.view;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.model.bean.Letter;
import com.mredrock.date.widget.BaseViewHolder;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterViewHolder extends BaseViewHolder<Letter> implements View.OnClickListener{
    private SimpleDraweeView sdvAvatar;
    private TextView tvUserName;
    private TextView tvContent;

    public LetterViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_letter);
    }

    @Override
    public void setData(Letter data) {
        super.setData(data);
        initView();
        sdvAvatar.setImageURI(Uri.parse(data.getUserAvatar()));
        tvUserName.setText(data.getUserName());
        tvContent.setText(data.getContent());
    }

    private void initView() {
        sdvAvatar = $(R.id.sdv_avatar);
        tvUserName = $(R.id.tv_user_name);
        tvContent = $(R.id.tv_content);
        sdvAvatar.setOnClickListener(this);
        tvUserName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sdv_avatar:
            case R.id.tv_user_name:
                break;
            case R.id.tv_content:
                break;
        }
    }
}
